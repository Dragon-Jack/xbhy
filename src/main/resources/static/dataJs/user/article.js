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
                url: '/selectArticle',
                method: "post",
                data: this.params
            }).then(response => {
                this.pageInfo = response.data;
            }).catch(function (error) {
                console.log(error);
            })
        },
        find: function () {
            axios({
                url: '/title',
                params: {title: this.title}
            }).then(function () {

            }).catch(function (e) {
                console.log(e);
            })
        },
        detail: function (id) {
            axios({
                url: 'detail',
                params:{id:id}
            }).then(function (resp) {
                layer.params=resp.data;
                layer.open({
                    type: 2,
                    title: "文章内容",
                    content: "article_detail",
                    area: ["60%", "80%"],
                    end: () => {

                    }
                })
            }).catch(function (e) {
                console.log(e)
            })
        }
    },
    created: function () {
        this.selectAll();
    }
});