let vm = new Vue({
    el: '#all',
    data: {
        params: "",
        common: "",
        favorite: ""
    },
    methods: {
        selectAll: function () {
            axios({
                url: 'common',
                params: {id: this.params.id}
            }).then(res => {
                this.common = res.data;
            }).catch(function (e) {
                console.log(e)
            });
            axios({
                url: 'myFavorite',
                params: {aid: this.params.id}
            }).then(res => {
                this.favorite = res.data;
            }).catch(function (e) {
                console.log(e)
            });
        },
        add: function () {
            axios({
                url: 'add',
                params: {aid: this.params.id}
            }).then(res=> {
                layer.msg(res.data.msg)
                this.selectAll();
            }).catch(function (e) {
                console.log(e)
            })
        },
        del: function () {
            axios({
                url: 'del',
                params: {aid: this.params.id}
            }).then(res=> {
                layer.msg(res.data.msg)
                this.selectAll();
            }).catch(function (e) {
                console.log(e)
            })
        }
    },
    created: function () {
        this.params = parent.layer.params;

        this.selectAll();//在vue创建后调用函数返回数据
    },
    mounted: function () {

    }
});