// Khai báo ứng dụng AngularJS với tên 'myApp'
var app = angular.module('shopping-cart-app', []);

// Định nghĩa một controller cho ứng dụng
app.controller('shopping-cart-ctrl', function ($scope, $http) {


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

            var index = this.items.findIndex(item => item.id == id);
            this.items.splice(index,1);
            this.saveToLocalStorage();
        },

        // Xóa danh sách sản phẩm vào giỏ hàng
        clear() {
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


    $scope.isActive = function (viewLocation) {
        return viewLocation === $location.path();
    };

    // Khai báo hàm để đặt lớp active cho thẻ được chọn
    $scope.setActive = function (viewLocation) {
        $location.path(viewLocation);
    };


});