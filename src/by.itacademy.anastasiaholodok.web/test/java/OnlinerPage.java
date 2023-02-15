public class OnlinerPage {
    public static final String URL = "https://www.onliner.by/";
//    public static final String COPYRIGHT = "//div[@class=’footer-style__copy’]";
    public static final String COPYRIGHT = "/html/body/div[4]/footer/div/div/div/div[2]/div[2]";
    public static final String BUTTON_LOGIN = "//div[text()='Вход']";
    public static final String LOGO_ENTER = "//div[@class='auth-form__title auth-form__title_big auth-form__title_condensed-default']";
//    public static final String BUTTON_MODAL_LOGIN = "//div[@class='auth-button auth-button_primary auth-button_middle auth-form__button auth-form__button_width_full']";
    public static final String BUTTON_MODAL_LOGIN = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[3]/button";

//    public static final String LABEL_WITHOUT_PASSWORD = "//div[text()='Укажите пароль']";
    public static final String LABEL_WITHOUT_PASSWORD = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[2]/div/div/div[2]/div";

//    public static final String LABEL_WITHOUT_EMAIL = "//div[text()='Укажите ник или e-mail']";
    public static final String LABEL_WITHOUT_EMAIL = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[1]/div/div[2]/div/div/div[2]/div";
    public static final String INPUT_EMAIL = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[1]/div/div[2]/div/div/div/div/input";
}
