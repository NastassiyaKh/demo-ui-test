public class AmazonPage {
    public static final String URL = "https://www.amazon.com/";
    public static final String COPYRIGHT = "//*[@id=\"navFooter\"]/div[5]/span";
    public static final String BUTTON_CART = "//a[@href='/gp/cart/view.html?ref_=nav_cart']";
//        "//*[@id=\"nav-cart\"]";
    public static final String LABEL_WITHOUT_FILLING_CART = "//div[@class='a-row sc-your-amazon-cart-is-empty']";
//        "//*[@id=\"sc-active-cart\"]/div/div/div[2]/div[1]/h2";
    public static final String BUTTON_MODAL_LOGIN = "//a[@id='a-autoid-0-announce']";
//        "//*[@id=\"a-autoid-0-announce\"]/span";
    public static final String LOGO_LOGIN_FORM = "//div[@class='a-row a-spacing-base']/../h1[@class='a-spacing-small']";
//        "//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/form/div/div/div/h1";
    public static final String BUTTON_CONTINUE = "//input[@class='a-button-input']";
//        "//*[@id=\"continue\"]";
    public static final String LABEL_WITHOUT_AUTHORIZATION = "//*[@id=\"auth-email-missing-alert\"]/div/div";
//        "//div[text()=' Enter your email or mobile phone number ']";
}