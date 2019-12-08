let vm = new Vue({
    el: '#all',
    data: {
        params: {},
        pageInfo:{}
    },
    methods: {
        lookUser: function (pageNum,pageSize) {
            this.pageInfo.pageNum=pageNum;
            this.pageInfo.pageSize=pageSize;
            axios({
                url: 'lookUser',
                method:"post",
               data: this.params
            }).then(function (resp) {
                this.pageInfo=resp.data;
            }).catch(function (error) {
                console.log(error);
            })
        }
    },
    created: function () {
        this.lookUser();//在vue创建后调用函数返回数据
    }
});