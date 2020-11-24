var retrieveUserByToken = function () {
    axios.get("/common/retrieveUserByToken", {
        headers: {
            Authorization: localStorage.getItem("accessToken") != null ? "Bearer " + localStorage.getItem("accessToken") : ""
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
    axios.get("/client/user/retrieveUserAddressesByToken", {
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