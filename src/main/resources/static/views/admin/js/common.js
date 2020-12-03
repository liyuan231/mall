var adminAccessToken = localStorage.getItem("accessToken") != null ? "Bearer " + localStorage.getItem("accessToken") : null;

var retrieveAllSystemConfiguration=function (){
    axios.get("/system/listAll", {
        headers: {
            Authorization: adminAccessToken
        }
    })
        .then(function (response) {
            if (response.data.code === 200) {
                this.app.systems = response.data.data;
            }
        }).catch(function (err) {
        console.log(err);
    })
}


var retrieveStorageByPageAndPageSize = function (page, pageSize) {
    axios.get("/storage/listSearch?page=" + page + "&pageSize=" + pageSize, {
        headers: {
            Authorization: adminAccessToken
        }
    })
        .then(function (response) {
            if (response.data.code === 200) {
                this.app.pageInfo = response.data.data;
            }
        }).catch(function (err) {
        console.log(err);
    })
}


var retrieveAdministratorByPageAndPageSize = function (page, pageSize) {
    axios.get("/administrator/listSearch?page=" + page + "&pageSize=" + pageSize, {
        headers: {
            Authorization: adminAccessToken
        }
    })
        .then(function (response) {
            if (response.data.code === 200) {
                this.app.pageInfo = response.data.data;
            }
        }).catch(function (err) {
        console.log(err);
    })
}


var retrieveAdvertisementByPageAndPageSize = function (page, pageSize) {
    axios.get("/advertisement/listSearch?page=" + page + "&pageSize=" + pageSize, {
        headers: {
            Authorization: adminAccessToken
        }
    })
        .then(function (response) {
            if (response.data.code === 200) {
                this.app.pageInfo = response.data.data;
            }
        }).catch(function (err) {
        console.log(err);
    })
}

var retrieveCommonQuestionByPageAndPageSize = function (page, pageSize) {
    axios.get("/commonQuestion/listSearch?page=" + page + "&pageSize=" + pageSize, {
        headers: {
            Authorization: adminAccessToken
        }
    })
        .then(function (response) {
            if (response.data.code === 200) {
                this.app.pageInfo = response.data.data;
            }
        }).catch(function (err) {
        console.log(err);
    })
}


var retrieveGoods = function (page, pageSize) {
    axios.get("/client/goods/listSearch?page=" + page + "&pageSize=" + pageSize, {
        headers: {
            Authorization: adminAccessToken
        }
    })
        .then(response => {
            console.log(response.data.message);
            if (response.data.code === 200) {
                this.app.pageInfo = response.data.data;
                console.log(response.data.data);
            }
        }).catch(err => {
        console.log(err);
    })
}


var deleteGoodsById = function (goodsId) {
    axios.delete("/admin/goods/" + goodsId, {
        headers: {
            Authorization: adminAccessToken
        }
    })
        .then(response => {
            console.log(response.data.message)
            if (response.data.code === 200) {
                console.log("下架成功！");
                alert("下架成功！");
                retrieveGoods(this.app.pageInfo.pageNum, this.app.pageInfo.pageSize);
            }
        }).catch(err => {
        console.log(err);
    })
}

var retrieveOrderByPageAndPageSize = function (page, pageSize) {
    axios.get("/order/listSearch?page=" + page + "&pageSize=" + pageSize, {
        headers: {
            Authorization: adminAccessToken
        }
    })
        .then(function (response) {
            if (response.data.code === 200) {
                this.app.pageInfo = response.data.data;
            }
        }).catch(function (err) {
        console.log(err);
    })

}

var retrieveAddressByPageAndPageSize = function (page, pageSize) {
    console.log("获取规定的地址");
    axios.get("/address/listSearch?page=" + page + "&pageSize=" + pageSize, {
        headers: {
            Authorization: adminAccessToken
        }
    })
        .then(function (response) {
            console.log(response.data);
            if (response.data.code === 200) {
                var info = response.data.data;
                this.app.pageInfo = info;
            }
        }).catch(function (e) {
        console.log(e);
    });
}

var retrieveAdminByToken = function () {
    console.log(localStorage.getItem("accessToken"));
    axios.get("/common/retrieveAdminByToken", {
        headers: {
            Authorization: adminAccessToken
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

var updateAdminAvatar = function (event) {
    const file = event.target.files[0];
    var forms = new FormData();
    forms.append('file', file);
    axios.post("/common/file/uploadAdminAvatar", forms, {
        headers: {
            'Content-type': 'multipart/form-data',
            Authorization: adminAccessToken
        }
    }).then(response => {
        if (response.data.code === 200) {
            console.log(response.data.data);
            retrieveAdminByToken();
        }
    }).catch(err => {
        console.log(err);
    })
}


var retrieveUserByPageAndPageSize = function (page, pageSize) {
    console.log("获取规定的用户");
    axios.get("/user/listSearch?page=" + page + "&pageSize=" + pageSize, {
        headers: {
            Authorization: adminAccessToken
        }
    })
        .then(function (response) {
            console.log(response.data);
            if (response.data.code === 200) {
                var info = response.data.data;
                this.app.pageInfo = info;
            }
        }).catch(function (e) {
        console.log(e);
    });
}

var retrieveSearchHistory = function (page, pageSize) {
    console.log("获取用户搜索历史信息！");
    axios.get("/admin/searchHistory/listSearch?page=" + page + "&pageSize=" + pageSize, {
        headers: {
            Authorization: adminAccessToken
        }
    })
        .then(response => {
            console.log(response.data.message);
            if (response.data.code === 200) {
                this.app.pageInfo = response.data.data;
            }
        }).catch(err => {
        console.log(err);
    })
}


var retrieveFeedbackByPageAndPageSize = function (page, pageSize) {
    console.log("获取地址");
    axios.get("/feedback/listSearch?page=" + page + "&pageSize=" + pageSize, {
        headers: {
            Authorization: adminAccessToken
        }
    })
        .then(function (response) {
            console.log(response.data.message);
            if (response.data.code === 200) {
                var info = response.data.data;
                this.app.pageInfo = info;
            }
        }).catch(function (e) {
        console.log(e);
    });
}