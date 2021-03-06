const HomePage = { template: '<homepage></homepage>' }
const LoginPage = { template: '<login></login>' }
const SignUpPage = { template: '<signup></signup>' }
const HomeLoggedInPage = { template: '<homeLoggedIn></homeLoggedIn>' }
const ProfilePage = { template: '<profile></profile>' }
const HomeLoggedInBuyerPage = { template: '<homeLoggedInBuyer></homeLoggedInBuyer>' }
const AllUsersAdminPage = { template: '<allUsersAdmin></allUsersAdmin>' }
const newManagerPage = { template: '<newManager></newManager>' }
const newDelivererPage = { template: '<newDeliverer></newDeliverer>' }
const newRestaurantPage = { template: '<newRestaurant></newRestaurant>' }
const HomeLoggedInManager = { template: '<homeLoggedInManager></homeLoggedInManager>' }
const HomeLoggedInDeliverer = { template: '<homeLoggedInDeliverer></homeLoggedInDeliverer>' }
const RestaurantInfoPage = { template: '<restaurantInfo></restaurantInfo>' }
const RestaurantManagerPage = { template: '<restaurantManager></restaurantManager>' }
const OrdersManagerPage = { template: '<ordersManager></ordersManager>' }
const CreateItemPage = { template: '<createItemManager></createItemManager>' }
const EditItemManagerPage = { template: '<editItemManager></editItemManager>' }
const RestaurantInfoBuyerPage = { template: '<restaurantInfoBuyers></restaurantInfoBuyers>' }
const Basket = { template: '<basket></basket>' }
const OrdersBuyerPage = { template: '<ordersBuyer></ordersBuyer>' }
const BuyerCardPage = { template: '<buyerCard></buyerCard>' }
const AllOrdersDelivererPage= { template: '<allOrdersDeliverer></allOrdersDeliverer>' }
const OrdersDelivererPage = { template: '<ordersDeliverer></ordersDeliverer>' }
const DeliveryRequests = { template: '<deliveryRequestsManager></deliveryRequestsManager>' }
const EditProfileDataPage = { template: '<editProfileData></editProfileData>' }
const ChangePassword = { template: '<changePassword></changePassword>' }
const DeliveredOrdersPage = { template: '<deliveredOrders></deliveredOrders>' }
const WriteAReviewPage = { template: '<writeAReview></writeAReview>' }
const ReviewManagerPage = { template: '<reviewManager></reviewManager>' }
const ReviewAdminPage = { template: '<reviewAdmin></reviewAdmin>' }
const ReviewPage = { template: '<reviewBuyer></reviewBuyer>' }
const MapViewOnlyContainter = { template: '<map-view-container></map-view-container>' }
const MapContainter = { template: '<map-container></map-container>' }
const HomeMapPage = { template: '<homeMap></homeMap>' }
const ShowMapBuyer = { template: '<showMapBuyer></showMapBuyer>' }
const RestInfoAdmin = { template: '<restaurantInfoAdmin></restaurantInfoAdmin>' }
const RestInfoManager = { template: '<restaurantInfoManager></restaurantInfoManager>' }
const RestInfoDeliverer = { template: '<restaurantInfoDeliverer></restaurantInfoDeliverer>' }
const RestMap = { template: '<restaurantMap></restaurantMap>' }
const ReviewInfoPage = { template: '<reviewInfo></reviewInfo>' }
const ShowMapInfoRestaurantPage = { template: '<showMapInfoRestaurant></showMapInfoRestaurant>' }
const ReviewInfoAdminPage = { template: '<reviewInfoAdmin></reviewInfoAdmin>' }
const ShowMapAdminPage = { template: '<showMapAdmin></showMapAdmin>' }
const ReviewInfoDelivererPage = { template: '<reviewInfoDeliverer></reviewInfoDeliverer>' }
const ShowMapDelivererPage = { template: '<showMapDeliverer></showMapDeliverer>' }
const ReviewInfoManagerPage = { template: '<reviewInfoManager></reviewInfoManager>' }
const ShowMapManagerPage = { template: '<showMapManager></showMapManager>' }



const router = new VueRouter({
    mode: 'hash',
      routes: [
        { path: '/', name: 'home', component: HomePage},
        { path: '/login', component: LoginPage},
        { path: '/signup', component: SignUpPage},
		{ path: '/homeLoggedIn/:id', component: HomeLoggedInPage},
		{ path: '/profile/:id', component: ProfilePage},
		{ path: '/homeLoggedInBuyer/:id', component: HomeLoggedInBuyerPage},
		{ path: '/allUsersAdmin/:id', component: AllUsersAdminPage},
    { path: '/newManager/:id', component: newManagerPage},
    { path: '/newRestaurant/:id', component: newRestaurantPage},
    { path: '/newDeliverer/:id', component: newDelivererPage},
    { path: '/homeLoggedInManager/:id', component: HomeLoggedInManager},
    { path: '/homeLoggedInDeliverer/:id', component: HomeLoggedInDeliverer},
    { path: '/restaurantInfo/:id', component: RestaurantInfoPage},
    { path: '/restaurantManager/:id/:idRest', component: RestaurantManagerPage},
    { path: '/ordersManager/:id', component: OrdersManagerPage},
    { path: '/createItemManager/:id', component: CreateItemPage},
    { path: '/createItemManager/:id', component: CreateItemPage},
    { path: '/editItemManager/:id', component: EditItemManagerPage},
    { path: '/restaurantInfoBuyers/:idRest/:id', component: RestaurantInfoBuyerPage},
    { path: '/basket/:idRest/:id', component: Basket},
    { path: '/ordersBuyer/:id', component: OrdersBuyerPage},
    { path: '/buyerCard/:id', component: BuyerCardPage},
    { path: '/allOrdersDeliverer/:id', component: AllOrdersDelivererPage},
    { path: '/ordersDeliverer/:id', component: OrdersDelivererPage},
    { path: '/deliveryRequestsManager/:id', component: DeliveryRequests},
    { path: '/editProfileData/:id', component: EditProfileDataPage},
    { path: '/changePassword/:id', component: ChangePassword},
    { path: '/deliveredOrders/:id', component: DeliveredOrdersPage},
    { path: '/writeAReview/:id/:idRest/:idOrd', component: WriteAReviewPage},
    { path: '/reviewManager/:id', component: ReviewManagerPage},
    { path: '/reviewAdmin/:id', component: ReviewAdminPage},
    { path: '/reviewBuyer/:id/:idRest', component: ReviewPage},
    { path: '/map-view-container', component: MapViewOnlyContainter},
    { path: '/map-container', component: MapContainter},
    { path: '/homeMap/:id', component: HomeMapPage},
    { path: '/showMapBuyer/:id/:idRest', component: ShowMapBuyer},
    { path: '/restaurantInfoAdmin/:id/:idRest', component: RestInfoAdmin},
    { path: '/restaurantInfoManager/:id/:idRest', component: RestInfoManager},
    { path: '/restaurantInfoDeliverer/:id/:idRest', component: RestInfoDeliverer},
    { path: '/restaurantMap/:idRest', component: RestMap},
    { path: '/reviewInfo/:idRest', component: ReviewInfoPage},
    { path: '/showMapInfoRestaurant/:idRest', component: ShowMapInfoRestaurantPage},
    { path: '/reviewInfoAdmin/:idRest/:id', component: ReviewInfoAdminPage},
    { path: '/showMapAdmin/:idRest/:id', component: ShowMapAdminPage},
    { path: '/reviewInfoDeliverer/:idRest/:id', component: ReviewInfoDelivererPage},
    { path: '/showMapDeliverer/:idRest/:id', component: ShowMapDelivererPage},
    { path: '/reviewInfoManager/:idRest/:id', component: ReviewInfoManagerPage},
    { path: '/showMapManager/:idRest/:id', component: ShowMapManagerPage},
      ]
});

var app = new Vue({
    router,
    el: '#app'
})