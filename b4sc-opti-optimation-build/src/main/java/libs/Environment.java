package libs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface Environment extends Config {

    @Key("app.url")
    String getAppURL();

    @Key("username.provider")
    String getProviderUsername();

    @Key("password.provider")
    String getProviderPassword();

    @Key("organisation.provider")
    String getProviderOrganisation();

    @Key("username.coordinator")
    String getCoordinatorUsername();

    @Key("password.coordinator")
    String getCoordinatorPassword();

    @Key("organisation.coordinator")
    String getCoordinatorOrganisation();

    @Key("app.testdata")
    String getTestDataPath();

}
