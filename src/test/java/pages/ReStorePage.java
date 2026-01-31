package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class ReStorePage {

    private final SelenideElement header = $("header");
    private final SelenideElement headerLogo = $("a.header-logo__link-full");
    private final SelenideElement regionButton = $("header button.location");
    private final SelenideElement headerServices = $(".header-services");
    private final SelenideElement bonusMenu = $(".bonus-menu");
    private final SelenideElement headerIcons = $(".header-icons");
    private final SelenideElement favoritesIcon = $("a.header-icons__link[href='/favorites/']");
    private final SelenideElement compareIcon = $("a.header-icons__link[href='/compare/']");
    private final SelenideElement cartIcon = $("a.header-icons__link[href='/order/cart/']");
    private final SelenideElement lkIcon = $(".header-icons__lk");
    private final SelenideElement headerMenu = $(".header-menu");
    private final SelenideElement servicesLink = $("a.header-services");
    private final ElementsCollection dialogs = $$("div, section, dialog");
    private final SelenideElement cookieBanner = $(".cookie-agreement");
    private final SelenideElement cookieAcceptButton = $(".cookie-agreement button.btn--black");
    private final SelenideElement mainBanner = $(".main-banner");
    private final ElementsCollection mainBannerLinks = $$("a.main-banner__link-full");
    private final ElementsCollection swiperSlides = $$(".swiper-slide");
    private final SelenideElement bestSellers = $("#gf-recs-gf-reco-1");
    private final ElementsCollection giftCardLinks = $$("a[href='/gift/']");
    private final SelenideElement categoriesSection = $("section.section-categories");
    private final SelenideElement brandsSection = $("section.section-brands");
    private final SelenideElement brandsSlider = $("section.section-brands .brands__slider");
    private final ElementsCollection brandSlides = $("section.section-brands .swiper-wrapper").$$(".brands__slide");
    private final ElementsCollection brandImages = $("section.section-brands .swiper-wrapper").$$("img");
    private final SelenideElement sectionBanners = $(".section-banners");
    private final ElementsCollection bannerCustomization = $$(".section-banners a[href='/promo/customization/']");
    private final ElementsCollection bannerServiceCards = $$(".section-banners a[href='/promo/service-cards/']");
    private final SelenideElement allNewsBanner = $("a[href='/allnews/']");
    private final SelenideElement appLinksBanner = $("a[href='/applinks/']");
    private final ElementsCollection sampleSections = $$("section.sample-section");
    private final SelenideElement bottomBanners = $("div.section-banners.section-banners-bottom");
    private final ElementsCollection promoCards = bottomBanners.$$(".promo-card");
    private final ElementsCollection promoCardLinks = bottomBanners.$$("a.promo-card__link[href]");
    private final SelenideElement restoreUBannerLink = bottomBanners.$("a.promo-card__link[href*='/promo/restore-u/']");
    private final SelenideElement liveBannerLink = bottomBanners.$("a.promo-card__link[href*='/live/']");
    private final SelenideElement searchLine = $(".search-line");
    private final ElementsCollection productLinks = $$("a.product-card__link");
    private final ElementsCollection anyButtonsOrLinks = $$("button, a");
    private final SelenideElement favoriteButtonOnCard = $("button.favorite__button");
    private final SelenideElement cartLayout = $(".page-cart-layout");
    private final SelenideElement cartButton = $("#cartButton");

    @Step("Открыть главную страницу")
    public ReStorePage openHome() {
        open("/");
        return this;
    }

    @Step("Проверить что header видим")
    public ReStorePage headerShouldBeVisible() {
        header.shouldBe(visible);
        return this;
    }

    @Step("Закрыть cookies если отображаются")
    public ReStorePage closeCookiesIfVisible() {
        if (cookieBanner.exists() && cookieBanner.is(visible)) {
            cookieAcceptButton.shouldBe(visible).click();
            cookieBanner.should(disappear);
        }
        return this;
    }

    @Step("Нажать кнопку выбора региона в header")
    public ReStorePage clickRegionButton() {
        regionButton.shouldBe(visible).click();
        return this;
    }

    @Step("Проверить модалку выбора региона (должен быть текст 'Ваш регион')")
    public ReStorePage regionModalShouldBeVisible() {
        dialogs.findBy(text("Ваш регион")).shouldBe(visible);
        return this;
    }

    @Step("Выбрать регион: {city}")
    public ReStorePage chooseRegion(String city) {
        SelenideElement modal = dialogs.findBy(text("Ваш регион")).shouldBe(visible);
        modal.$$("*").findBy(exactText(city)).shouldBe(visible).click();
        return this;
    }

    @Step("Проверить что в header выбран город: {city}")
    public ReStorePage headerShouldContainCity(String city) {
        header.shouldHave(text(city));
        return this;
    }

    @Step("Лого отображается")
    public ReStorePage logoShouldBeVisible() {
        headerLogo.shouldBe(visible);
        return this;
    }

    @Step("Черное меню: проверка пунктов")
    public ReStorePage blackMenuShouldHaveItems() {
        headerServices.shouldHave(text("Магазины"));
        headerServices.shouldHave(text("Сервисные центры"));
        headerServices.shouldHave(text("Бизнесу"));
        headerServices.shouldHave(text("Блог"));
        headerServices.shouldHave(text("Live"));
        headerServices.shouldHave(text("restore:u"));
        headerServices.shouldHave(text("Доставка и оплата"));
        headerServices.shouldHave(text("Где мой заказ?"));
        return this;
    }

    @Step("Бонус-меню: проверка пунктов")
    public ReStorePage bonusMenuShouldHaveItems() {
        bonusMenu.shouldHave(text("New"));
        bonusMenu.shouldHave(text("Привилегии"));
        bonusMenu.shouldHave(text("Подарочная карта"));
        bonusMenu.shouldHave(text("SMART-уход"));
        bonusMenu.shouldHave(matchText("(?s).*(Sale|Акции).*"));
        return this;
    }

    @Step("Иконки header: отображаются все нужные")
    public ReStorePage headerIconsShouldBeVisible() {
        headerIcons.shouldBe(visible);
        favoritesIcon.shouldBe(visible);
        compareIcon.shouldBe(visible);
        cartIcon.shouldBe(visible);
        lkIcon.shouldBe(visible);
        return this;
    }

    @Step("Main меню: проверка пунктов")
    public ReStorePage mainMenuShouldHaveItems() {
        headerMenu.shouldHave(text("Apple"));
        headerMenu.shouldHave(text("Смартфоны и гаджеты"));
        headerMenu.shouldHave(text("Компьютеры и ноутбуки"));
        headerMenu.shouldHave(text("ТВ, аудио и видео"));
        headerMenu.shouldHave(text("Для дома"));
        headerMenu.shouldHave(text("Красота и здоровье"));
        headerMenu.shouldHave(text("Развлечения"));
        headerMenu.shouldHave(text("Путешествия и спорт"));
        headerMenu.shouldHave(text("Аксессуары"));
        servicesLink.shouldHave(text("Сервисы"));
        return this;
    }

    @Step("Баннерные слайды: блок баннера виден + есть ссылка + есть слайды")
    public ReStorePage bannerSliderShouldBeCorrect() {
        mainBanner.shouldBe(visible);
        mainBannerLinks.first().shouldBe(visible);
        swiperSlides.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Бестселлеры: блок виден")
    public ReStorePage bestSellersShouldBeVisible() {
        bestSellers.shouldBe(visible);
        return this;
    }

    @Step("Подарочная карта: есть ссылки")
    public ReStorePage giftCardLinksShouldExist() {
        giftCardLinks.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Категории (плитки): секция видна и есть основные плитки")
    public ReStorePage categoryTilesShouldBeCorrect() {
        categoriesSection.shouldBe(visible);

        categoriesSection.$("a.card__full[href*='/apple/']").shouldBe(visible);
        categoriesSection.$("a.card__full[href*='/smartfony/samsung/']").shouldBe(visible);
        categoriesSection.$("a.card__full[href*='/smartfony/huawei/']").shouldBe(visible);
        categoriesSection.$("a.card__full[href*='/smartfony/xiaomi/']").shouldBe(visible);
        categoriesSection.$("a.card__full[href*='/aksessuary/']").shouldBe(visible);
        categoriesSection.$("a.card__full[href*='/smartfony-i-gadzhety/']").shouldBe(visible);
        categoriesSection.$("a.card__full[href*='/kompyutery-i-noutbuki/']").shouldBe(visible);
        categoriesSection.$("a.card__full[href*='/tv-audio-video/']").shouldBe(visible);
        categoriesSection.$("a.card__full[href*='/krasota-i-zdorove/']").shouldBe(visible);
        categoriesSection.$("a.card__full[href*='/bytovaya-tekhnika/']").shouldBe(visible);

        return this;
    }

    @Step("Секция брендов: секция/слайдер/слайды/картинки существуют")
    public ReStorePage brandsSectionShouldBeCorrect() {
        brandsSection.scrollIntoView(true).shouldBe(visible);
        brandsSlider.shouldBe(visible);
        brandSlides.shouldHave(sizeGreaterThan(0));
        brandImages.filterBy(visible).shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Секция промо-баннеров: 2 баннера customization и service-cards")
    public ReStorePage promoBannersShouldBeCorrect() {
        sectionBanners.scrollIntoView(true).shouldBe(visible);
        sectionBanners.shouldBe(visible);

        bannerCustomization.filter(visible).shouldHave(size(1));
        bannerServiceCards.filter(visible).shouldHave(size(1));
        return this;
    }

    @Step("Баннеры 'Акции и новости' и 'Мобильное приложение' отображаются")
    public ReStorePage newsAndAppBannersShouldBeVisible() {
        sectionBanners.shouldBe(visible);
        allNewsBanner.shouldBe(visible);
        appLinksBanner.shouldBe(visible);
        return this;
    }

    @Step("Блок 'Читай, смотри, действуй': заголовок и табы корректны")
    public ReStorePage blogBlockShouldBeCorrect() {
        SelenideElement blogBlock = sampleSections
                .findBy(text("Читай, смотри, действуй"))
                .shouldBe(visible);

        blogBlock.$(".sample-section__title")
                .shouldBe(visible)
                .shouldHave(exactText("Читай, смотри, действуй"));

        blogBlock.$$(".tab-button")
                .shouldHave(texts("Все", "Гаджеты", "iPhone", "iPad", "Apple Watch", "Mac"));

        return this;
    }

    @Step("Нижние баннеры: 2 карточки + картинки + 2 ссылки + нужные ссылки restore-u и live")
    public ReStorePage bottomBannersShouldBeCorrect() {
        SelenideElement banners = bottomBanners.scrollTo().shouldBe(visible);

        promoCards.shouldHave(size(2));
        promoCards.forEach(card -> card.$("picture.promo-card__img").shouldBe(visible));

        promoCardLinks.shouldHave(size(2));
        restoreUBannerLink.shouldBe(visible);
        liveBannerLink.shouldBe(visible);

        return this;
    }

    @Step("Кликнуть в поиск")
    public ReStorePage clickSearch() {
        searchLine.shouldBe(visible).click();
        return this;
    }

    @Step("Ввести в поиск: {query} и нажать Enter")
    public ReStorePage typeSearchAndSubmit(String query) {
        actions().sendKeys(query).sendKeys(Keys.ENTER).perform();
        return this;
    }

    @Step("Открыть товар из выдачи по regex: {regex}")
    public ReStorePage openProductFromResultsByRegex(String regex) {
        closeCookiesIfVisible();

        SelenideElement product = productLinks.findBy(matchText(regex))
                .shouldBe(visible)
                .scrollIntoView("{block:'center'}");
        product.click(ClickOptions.usingJavaScript());
        return this;
    }

    @Step("Нажать кнопку 'Оформить/Купить/В корзину/Добавить/Перейти к оформлению'")
    public ReStorePage clickBuyOrCheckoutButton() {
        SelenideElement buyBtn = anyButtonsOrLinks
                .filterBy(visible)
                .findBy(matchText("(?s).*(Оформить|Купить|В корзину|Добавить в корзину|Перейти к оформлению).*"));

        buyBtn.scrollIntoView("{block:'center'}");
        buyBtn.shouldBe(visible, enabled);
        buyBtn.click(ClickOptions.usingJavaScript());
        return this;
    }

    @Step("Открыть корзину (иконка в header)")
    public ReStorePage openCartFromHeader() {
        cartIcon.shouldBe(visible).click();
        return this;
    }

    @Step("Корзина содержит товар (regex): {regex}")
    public ReStorePage cartShouldContain(String regex) {
        cartLayout.shouldBe(visible).shouldHave(matchText(regex));
        return this;
    }

    @Step("Нажать 'Перейти к оформлению'")
    public ReStorePage clickGoToCheckout() {
        cartButton.shouldBe(visible).click();
        return this;
    }

    @Step("Проверить, что мы на странице оформления заказа")
    public ReStorePage checkoutPageShouldBeOpened() {
        webdriver().shouldHave(urlContaining("/order/delivery"));
        $("body").shouldHave(matchText("(?s).*Оформление заказа.*"));
        return this;
    }

    @Step("Открыть страницу поиска по товару: {productName}")
    public ReStorePage openSearchByProductName(String productName) {
        open("/search/?q=" + urlEncode(productName));
        return this;
    }

    @Step("Открыть карточку товара из поиска по regex: {regex}")
    public ReStorePage openProductCardFromSearchByRegex(String regex) {
        $$("a.product-card__link[href*='/catalog/']")
                .findBy(matchText(regex))
                .shouldBe(visible)
                .scrollIntoView("{block:'center'}")
                .click();
        return this;
    }

    @Step("Нажать 'Избранное' (сердце) на карточке товара")
    public ReStorePage clickFavoriteOnProductCard() {
        favoriteButtonOnCard.shouldBe(visible).scrollIntoView("{block:'center'}")
                .click(ClickOptions.usingJavaScript());
        return this;
    }

    @Step("Открыть избранное через иконку в header")
    public ReStorePage openFavoritesFromHeader() {
        favoritesIcon.shouldBe(visible).click();
        return this;
    }

    @Step("Проверить что мы на странице /favorites")
    public ReStorePage favoritesPageShouldBeOpened() {
        webdriver().shouldHave(urlContaining("/favorites"));
        return this;
    }

    @Step("Проверить что в избранном есть товар (regex): {regex}")
    public ReStorePage favoritesShouldContain(String regex) {
        $$("a.product-card__link[href*='/catalog/']")
                .findBy(matchText(regex))
                .shouldBe(visible);
        return this;
    }

    private String urlEncode(String s) {
        return s.replace(" ", "+").replace(",", "%2C");
    }
}