new Vue({
    el:'#goodslistdiv',
    data:{
        list:[],
        pageInfo:{},
        pageNum:1,
        pageSize:3,
        searchEntity:{},
    },
    methods:{

        /**
         * 分页
         * @param pageNum
         */
        paging:function(pageNum){
            if(pageNum==0){
                pageNum = 1;
            }
            this.pageNum = pageNum;
            this.findAllConnAndPage();
        },

        /**
         * 分页查询全部商品信息
         * 根据商品名称模糊查询商品信息
         */
        findAllConnAndPage:function () {
            var _this = this;
            var url = '../goods/findAllConnAndPage?pageNum=' + this.pageNum + "&pageSize=" + this.pageSize;
            axios.post(url,_this.searchEntity).then(function (response) {
                _this.list = response.data.list;
                _this.pageNum = response.data.pageNum;
                _this.pageSize = response.data.pageSize;
                _this.pageInfo = response.data;
            });

        }
    },
    created:function () {
        this.findAllConnAndPage();
    }
});