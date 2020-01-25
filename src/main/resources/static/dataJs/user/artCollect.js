let vm = new Vue({
    el: '#all',
    data: {
        pageInfo: {},
        params: {}
    },
    methods: {
        selectAll: function (pageNum, pageSize) {
            this.params.pageNum = pageNum;
            this.params.pageSize = pageSize;
            axios({
                url: '/myArt',
                method: "post",
                data: this.params
            }).then(resp => {
                console.log(resp.data);
                this.pageInfo = resp.data;
            }).catch(function (error) {
                console.log(error);
            })
        },
        lookArt: function (id) {
            axios({
                url: 'detail',
                params: {id: id}
            }).then(function (resp) {
                layer.params = resp.data;
                layer.open({
                    type: 2,
                    title: "文章内容",
                    content: "article_detail",
                    area: ["60%", "80%"],
                    end: () => {
                        if (layer.close(index())) {
                            this.selectAll();
                        }
                    }
                })
            }).catch(function (e) {
                console.log(e);
            })
        }
    },
    created: function () {
        this.selectAll();//在vue创建后调用函数返回数据
    }
});