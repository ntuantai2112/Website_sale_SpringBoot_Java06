// Khai báo ứng dụng AngularJS với tên 'myApp'
var app = angular.module('shopping-cart-app', []);

// Định nghĩa một controller cho ứng dụng
app.controller('shopping-cart-ctrl', function ($scope, $http,$location) {


//    QUẢN LÝ GIỎ HÀNG

    $scope.cart = {

        //  Danh sách sản phẩm trong giỏ hàng
        items: [],

        //  Thêm sản phẩm vào giỏ hàng
        add(id) {
            // Lấy ra item và kiểm tra
            var item = this.items.find(item => item.id == id);
            //Nếu sản phẩm đã có trong giỏ hàng thì tăng số lượng lên 1
            if (item) {
                item.qty++;
                this.saveToLocalStorage();
            } else {
                $http.get(`/rest/products/${id}`).then(resp => {
                    resp.data.qty = 1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                    // Hiển thị thông báo thành công
                    this.showSuccessAlert();
                    alert("Product added to cart successfully.");
                })
            }


        },

        // Hiển thị thông báo thành công
        showSuccessAlert() {
            // Hiển thị alert thành công bằng cách thêm class show
            document.getElementById('success-alert').classList.add('show');
            // Ẩn alert sau 3 giây
            setTimeout(function(){
                document.getElementById('success-alert').classList.remove('show');
            }, 3000);
        },

        //  Xóa sản phẩm vào giỏ hàng
        remove(id) {
            // Hiển thị hộp thoại xác nhận trước khi xóa
            if (confirm("Are you sure you want to remove this item from your cart?")) {
                var index = this.items.findIndex(item => item.id == id);
                this.items.splice(index, 1);
                this.saveToLocalStorage();
            }
        },

        // Xóa danh sách sản phẩm vào giỏ hàng
        clear() {
            if (confirm("Are you sure you want to clear your cart?")) {
                // Xóa tất cả các sản phẩm trong mảng items
                this.items = [];
                // Lưu thay đổi vào local storage
                this.saveToLocalStorage(); // Thêm dòng này để lưu thay đổi
                alert("Clear Successfully!")
            }
        },

        // Tính thành tiền của 1 sản phẩm
        amt_of(item) {
        },

        // Tính tổng số lượng các mặt hàng trong giỏ hàng
        get count() {
            return this.items
                .map(item => item.qty)
                .reduce((total, qty) => total += qty, 0);

        },

        // Tính tổng số tiền (thành tiền) các mặt hàng trong giỏ hàng
        get amount() {
            return this.items
                .map(item => item.qty * item.price)
                .reduce((total, qty) => total += qty, 0);
        },

        // Lưu sản phẩm trong giỏ hàng vào local storage
        saveToLocalStorage() {
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);
        },

        // Đọc giỏ hàng từ local Storage
        loadFromLocalStorage(){
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : [];
        }

    }
    //Gọi lại local Storage để hiển thị sản phẩm trong giỏ hàng
    $scope.cart.loadFromLocalStorage();


    $scope.getUsername = function() {
        var accountUsernameInput = document.getElementById('usernameInput');
        if (accountUsernameInput) {
            var accountUsername = accountUsernameInput.value;
            console.log(accountUsername);
        }

    };

    //    Định nghĩa đối tượng order
    $scope.order = {
        createDate: new Date(),
        address: "",
        account: {  username: $scope.getUsername() || "staff" }, // Khởi tạo username trống

        get orderDetails() {
            return $scope.cart.items.map(item => {
                return {
                    product:{id: item.id },
                    price: item.price,
                    quantity: item.qty
                }
            });
        },

        purchase() {
            var order = angular.copy(this);
            console.log(order);
            console.log(this.orderDetails);
            // Gọi hàm để lấy giá trị username từ ô input
            // $scope.getUsername();

            // Thực hiện đặt hàng
            $http.post("/rest/orders", order).then(resp => {
                alert("Đặt hàng thành công!");
                $scope.cart.items = [];
                $scope.cart.saveToLocalStorage();
                location.href = "/order/detail/" + resp.data.id;

            }).catch(error => {
                alert("Đặt hàng lỗi!");
                console.log(error);
            })
        }
    };


    // Kiểm tra xem một mục có phải là active hay không dựa trên địa chỉ URL hiện tại
    $scope.isActive = function (viewLocation) {
        return viewLocation === $location.path();
    };

    // Đặt địa chỉ URL hiện tại khi người dùng click vào một mục
    $scope.setActive = function (viewLocation) {
        $location.path(viewLocation);
    };


});