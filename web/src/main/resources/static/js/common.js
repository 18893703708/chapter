var pageSize=10;
function initCheck(){
    $('.all-checks').iCheck({
        checkboxClass: 'icheckbox_square-green',
        radioClass: 'iradio_square-green',
    });
    $('#all_check').on('ifChecked', function(event){

        $('.i-checks').iCheck('check');


    });
    $('#all_check').on('ifUnchecked', function(event){

        $('.i-checks').iCheck('uncheck');
    });

}

Vue.component('ui-checkbox', {
    template: '<input type="checkbox" class="i-checks"  >',
    mounted: function(){
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });

    }
})
