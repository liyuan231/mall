
var retrieveAd = function (index) {
    axios.get("/common/ad/" + index)
        .then(response => {
            console.log(response.data.message);
            if (response.data.code === 200) {
                this.app.ads = response.data.data;
            }
        }).catch(err => {
        console.log(err);
    })

}


var retrieveUserByToken = function () {
    console.log(localStorage.getItem("accessToken"));
    axios.get("/common/retrieveUserByToken", {
        headers: {
            Authorization: localStorage.getItem("accessToken") != null ? "Bearer " + localStorage.getItem("accessToken") : null
        }
    })
        .then(function (response) {
            console.log(response);
            if (response.data.code === 200) {
                this.app.currentUser = response.data.data;
            }
        }).catch(function (err) {
        console.log(err);
    })
}
var retrieveUserAddressesByToken = function () {
    console.log("获取用户地址！");
    axios.get("/client/address/retrieveAddressesByToken", {
        headers: {
            Authorization: localStorage.getItem("accessToken") != null ? "Bearer " + localStorage.getItem("accessToken") : ""
        }
    })
        .then(function (response) {
            console.log(response);
            if (response.data.code === 200) {
                this.app.addresses = response.data.data;
                console.log(this.app.addresses);
            }
        })
        .catch(function (err) {
            console.log(err);
        })
}

var accessToken = localStorage.getItem("accessToken") != null ? "Bearer " + localStorage.getItem("accessToken") : "";

var setCookie = function (key, value, expiration) {
    document.cookie = key + "=" + value;
}

var retrieveAllCategories = function () {
    axios.get("/client/category/listAll")
        .then(function (response) {
            console.log(response.data);
            if (response.data.code === 200) {
                this.app.categories = response.data.data;
            }
        }).catch(function (err) {
        console.log(err);
    });
}

var qCloudBaseUrl = "https://mall-1300780430.cos.ap-nanjing.myqcloud.com";

var retrieveQueryVariable = function (variable) {
    let s = window.location.search.substring(1);
    let strings = s.split("&");
    for (let i = 0; i < strings.length; i++) {
        let each = strings[i].split("=");
        if (each[0] === variable) {
            return each[1];
        }
    }
}
var retrieveGoodsById = function (goodsId) {
    axios.get("/client/goods/" + goodsId, {
        headers: {
            Authorization: localStorage.getItem("accessToken") != null ? "Bearer " + localStorage.getItem("accessToken") : ""
        }
    }).then(response => {
        if (response.data.code === 200) {
            this.app.newGoods = response.data.data;
        }
    }).catch(err => {
        console.log(err);
    })
}

var retrieveIndexGoods = function (page, pageSize) {
    axios.get("/client/goods/listSearch?page=" + page + "&pageSize=" + pageSize, {
        headers: {
            Authorization: localStorage.getItem("accessToken") != null ? "Bearer " + localStorage.getItem("accessToken") : ""
        }
    })
        .then(function (response) {
            if (response.data.code === 200) {
                this.app.newGoods = response.data.data;
            }
            console.log(response);
        })
        .catch(function (err) {
            console.log(err);
        })
}

var clientLogout = function () {
    console.log("logout!");
    localStorage.removeItem("accessToken");
    localStorage.removeItem("refreshToken");
    this.app.currentUser = {};
    setTimeout(function () {
        window.location.href = "/views/client/index.html"
    }, 500)
}