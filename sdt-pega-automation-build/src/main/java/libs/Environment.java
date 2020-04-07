package libs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface Environment extends Config {

    @Key("app.url")
    String getAppURL();

    @Key("pega.POLICE-SDW-WORK.host")
    String getPegaHost();

    @Key("pega.username")
    String getPegaUserName();

    @Key("pega.password")
    String getPegaPassword();

}
