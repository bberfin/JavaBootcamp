package org.example;


/*
Bir restoranın sipariş takip sistemini Java'da modellendirmeniz isteniyor.
Bu sistem, müşterilerin sipariş vermesine,
siparişleri ödemesine ve iptal etmesine,
sipariş bilgilerini görüntülemesine ve
siparişlerin hazırlandığını işaretlemesine olanak tanımalıdır.

Ayrıca, siparişlerin teslimat veya restorandan alınmak üzere olup olmadığına göre farklı işlemler yapılmalıdır.

Bu gereksinimlere uygun olarak bir RestaurantOrder sınıfı yazın.
Bu sınıfın field'ları şunlar olmalıdır:

*  orderId: int türünde, sipariş numarasını tutar.
*  customerName: String türünde, müşterinin adını tutar.
*  totalPrice: double türünde, siparişin toplam fiyatını tutar.
*  isDelivery: boolean türünde, siparişin teslim edilip edilmediğini tutar.
*  isPaid: boolean türünde, siparişin ödendiğini tutar.

Bu field'lar yalnızca getter ve setter yöntemleri aracılığıyla erişilebilir olmalıdır.
Ayrıca, sipariş bir yapıcı yönteme sahip ve tüm field'ları belirtilen değerlerle başlatılır.

Ayrıca, ödeme yapma, iptal etme, sipariş bilgilerini görüntüleme ve hazırlandığını işaretlemek için yöntemler tanımlanmalıdır.
Ödeme yapma yöntemi, siparişin ödendiğini işaretlerken, iptal etme yöntemi siparişin toplam fiyatını sıfırlar.
Sipariş bilgilerini görüntüleme yöntemi, sipariş numarası, müşteri adı, toplam fiyat, teslimat özelliği ve ödeme durumu bilgilerini ekrana yazdırır.
Hazırlandığını işaretlemek için ise bir boolean türünde isPrepared field'ı ve buna erişebilmek için getter ve setter yöntemleri tanımlanmalıdır.

Son olarak, teslimat durumuna göre farklı işlemler yapacak bir yöntem processOrder() olmalıdır.
Bu yöntem, isDelivery özelliğine göre siparişin teslim edildiğini veya restorandan alınacağını kontrol eder.
Teslim edilecekse sipariş hazırlanır ve müşteriye gönderilir, alınacaksa sipariş hazırlanır ve müşteriye hazır olduğu bildirilir.
*/
public class Main {
    public static void main(String[] args) {

        RestaurantOrder restaurantOrder = new RestaurantOrder(1, "berfin", 375, true, true);
        restaurantOrder.toPay();
        restaurantOrder.viewOrder();
        restaurantOrder.processOrder();

        RestaurantOrder restaurantOrder2 = new RestaurantOrder(2, "songül", 555, false, true);
        restaurantOrder2.toPay();
        restaurantOrder2.viewOrder();
        restaurantOrder2.processOrder();

        RestaurantOrder restaurantOrder3 = new RestaurantOrder(3, "ali", 720, true, false);
        restaurantOrder3.toPay();
        restaurantOrder3.viewOrder();
        restaurantOrder3.processOrder();


    }
}