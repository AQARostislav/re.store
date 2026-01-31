package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ReStorePage;

@Tag("regression")
public class ReStoreTests extends TestBase {

    private final ReStorePage page = new ReStorePage();

    @Test
    @DisplayName("Проверка выбора региона")
    @Tag("regression")
    @Owner("PuchkanevRostislav")
    void RegionTest() {
        page.openHome()
                .headerShouldBeVisible()
                .clickRegionButton()
                .regionModalShouldBeVisible()
                .closeCookiesIfVisible()
                .chooseRegion("Екатеринбург")
                .headerShouldContainCity("Екатеринбург");
    }

    @Test
    @DisplayName("Проверка разделов главной страницы")
    @Tag("regression")
    @Owner("PuchkanevRostislav")
    void HomePageTest() {
        page.openHome()
                // Лого
                .logoShouldBeVisible()
                // Черное меню
                .blackMenuShouldHaveItems()
                // Бонус меню
                .bonusMenuShouldHaveItems()
                // Иконки хедера
                .headerIconsShouldBeVisible()
                // Main меню
                .mainMenuShouldHaveItems()
                // Баннерные слайды
                .bannerSliderShouldBeCorrect()
                // Бестселлеры
                .bestSellersShouldBeVisible()
                // Подарочная карта
                .giftCardLinksShouldExist()
                // Категории "Плитки"
                .categoryTilesShouldBeCorrect()
                // Секция брендов
                .brandsSectionShouldBeCorrect()
                // Секция промо баннеров
                .promoBannersShouldBeCorrect()
                // Баннеры "Акции и новости" и "Мобильное приложение"
                .newsAndAppBannersShouldBeVisible()
                // блок "Читай, смотри, действуй"
                .blogBlockShouldBeCorrect()
                // нижние баннеры ("restore:u" и "Стримы")
                .bottomBannersShouldBeCorrect();
    }

    @Test
    @DisplayName("Проверка оформления товара")
    @Tag("regression")
    @Owner("PuchkanevRostislav")
    void makingAnOrder() {
        page.openHome()
                // Поиск: "17 pro max"
                .clickSearch()
                .typeSearchAndSubmit("17 pro max")
                // На выдаче кликаем нужный товар
                .openProductFromResultsByRegex(".*iPhone 17 Pro Max 1TB.*Silver.*")
                // В карточке товара жмём "Оформить"
                .clickBuyOrCheckoutButton()
                // Кликаем на иконку корзины
                .openCartFromHeader()
                // В корзине видим товар
                .cartShouldContain("(?s).*iPhone 17 Pro Max 1TB.*Silver.*")
                // Нажимаем "Перейти к оформлению"
                .clickGoToCheckout()
                // Попали на страницу оформления
                .checkoutPageShouldBeOpened();
    }

    @Test
    @DisplayName("Тест добавления товара в избранное")
    @Tag("regression")
    @Owner("PuchkanevRostislav")
    void addToFavoritesTest() {
        String productName = "Apple iPhone 17 Pro Max 1TB, Silver";
        page.openSearchByProductName(productName) // open("/search/?q=...")
                // На странице поиска находим карточку нужного товара и кликаем в неё
                .openProductCardFromSearchByRegex("(?s).*Apple iPhone 17 Pro Max 1TB.*Silver.*")
                // На карточке товара нажимаем "сердце" (избранное)
                .clickFavoriteOnProductCard()
                // Жмём иконку избранного в хедере
                .openFavoritesFromHeader()
                // Проверяем что мы на /favorites
                .favoritesPageShouldBeOpened()
                // Проверяем что товар есть в избранном
                .favoritesShouldContain("(?s).*Apple iPhone 17 Pro Max 1TB.*Silver.*");
    }
}