let vm = new Vue({
    el: '#all',
    data: {
        params: {}
    },
    methods: {
        selectAll: function () {
            axios({
                url: '/addArt',
                params: this.params
            }).then(function (resp) {
                layer.msg(resp.data.msg);
                let index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            }).catch(function (error) {
                console.log(error);
            })
        }
    },
    created: function () {
    }
});