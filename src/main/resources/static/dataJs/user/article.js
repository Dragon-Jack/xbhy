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
                url: 'selectarticle',
                params: this.params
            }).then(response => {
                console.log(response.data);
                this.pageInfo = response.data;
            }).catch(function (error) {
                console.log(error);
            })
        }
    },
    created: function () {
        this.selectAll();
    }
});