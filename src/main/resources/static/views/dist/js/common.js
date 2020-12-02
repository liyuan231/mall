var retrieveGoods = function (page, pageSize) {
    axios.get("/client/goods/listSearch?page=" + page + "&pageSize=" + pageSize)
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
    axios.delete("/admin/goods/" + goodsId)
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