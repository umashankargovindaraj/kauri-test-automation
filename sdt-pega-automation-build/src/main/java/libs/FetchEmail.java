package libs;

import com.sun.mail.pop3.POP3Folder;
import com.sun.mail.pop3.POP3SSLStore;
import org.testng.Assert;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;


public class FetchEmail {
    private Session session;
    private POP3SSLStore store;
    private String username;
    private String password;
    private POP3Folder folder;
    URLName url;
    public static String receiving_attachments = "files";

    public FetchEmail() {
        session = null;
        store = null;
    }

    public void setUserPass(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void connect()
            throws Exception {
        String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        Properties pop3Props = new Properties();
        pop3Props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
        pop3Props.setProperty("mail.pop3.socketFactory.fallback", "false");
        pop3Props.setProperty("mail.pop3.port", "995");
        pop3Props.setProperty("mail.pop3.socketFactory.port", "995");
        url = new URLName("pop3", "pop.gmail.com", 995, "", username, password);
        session = Session.getInstance(pop3Props, null);
        store = new POP3SSLStore(session, url);
        store.connect();
    }

    public void openFolder(String folderName)
            throws Exception {
        folder = (POP3Folder) store.getFolder(folderName);
        System.out.println((new StringBuilder("Fetching emails--")).append
                (folder.getParent().getFullName()).toString());
        if (folder == null)
            throw new Exception("Invalid folder");
        try {
            folder.open(2);
            System.out.println((new StringBuilder("Folder name----")).append
                    (folder.getFullName()).toString());
        } catch (Exception ex) {
            System.out.println((new StringBuilder("Folder Opening Exception..")).append(ex).toString());
        }
    }

    public void pollGmailForConfirmationEmail(String referenceNumber) throws Exception {

        long startTime = System.currentTimeMillis();
        boolean blnMailFound = false;
        while (!(blnMailFound) && (System.currentTimeMillis() - startTime) < 100000) {
            openFolder("INBOX");
            Message msgs[] = folder.getMessages();
            System.out.println("TOTAL NUMBER OF EMAILS : " + msgs.length);
            FetchProfile fp = new FetchProfile();
            folder.fetch(msgs, fp);
            for (int i = msgs.length - 1; i >= 0; i--) {
                Message message = msgs[i];
                dumpEnvelope(msgs[i]);
                String emailBody = getTextFromMimeMultipart((MimeMultipart) message.getContent());
                if (emailBody.contains("Your Online Report reference number is " + referenceNumber)) {
                    blnMailFound = true;
                    System.out.println("Email found with reference number " + referenceNumber + " found. ");
                    break;
                }
            }
        }
        if (!blnMailFound) {
            Assert.assertTrue(false, "Email for refNumber : " + referenceNumber + " not received");
        }
    }

    private static void dumpEnvelope(Message m) throws Exception {
        String body = "";
        String path = "";
        int size = 0;
        Object content = m.getContent();
        if (content instanceof String) {
            body = (String) content;
        } else if (content instanceof Multipart) {
            Multipart mp = (Multipart) content;
            for (int j = 0; j < mp.getCount(); j++) {
                Part part = mp.getBodyPart(j);
                String disposition = part.getDisposition();
                if (disposition == null) {
                    // Check if plain
                    MimeBodyPart mbp = (MimeBodyPart) part;
                    if (mbp.isMimeType("text/plain")) {
                        body += mbp.getContent().toString();
                    } else if (mbp.isMimeType("TEXT/HTML")) {
                        body += mbp.getContent().toString();
                    } else {
                        //unknown
                    }
                } else if ((disposition != null) &&
                        (disposition.equals(Part.ATTACHMENT) || disposition.equals
                                (Part.INLINE) || disposition.equals("ATTACHMENT") || disposition.equals
                                ("INLINE"))) {
                    // Check if plain
                    MimeBodyPart mbp = (MimeBodyPart) part;
                    if (mbp.isMimeType("text/plain")) {
                        body += (String) mbp.getContent();
                    } else if (mbp.isMimeType("TEXT/HTML")) {
                        body += mbp.getContent().toString();
                    } else {
                        File savedir = new File(receiving_attachments);
                        if (!savedir.exists()) {
                            savedir.mkdirs();
                        }
                        File savefile = new File(savedir + "/" + part.getFileName());
                        path = savefile.getAbsolutePath();
                        //size = saveFile(savefile, part);

                    }
                }
            }
        }

    }

    private String getTextFromMimeMultipart(
            MimeMultipart mimeMultipart) throws MessagingException, IOException {
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break; // without break same text appears twice in my tests
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
            }
        }
        return result;
    }
}
