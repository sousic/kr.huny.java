<script>
    CURRENT_URL = '${adminPath}/board/manager/list';

    $SIDEBAR_MENU.find('a[href="' + CURRENT_URL + '"]').parent('li').addClass('current-page');

    $SIDEBAR_MENU.find('a').filter(function () {
        //console.log(this.href + "," + CURRENT_URL);
        return this.href.indexOf(CURRENT_URL) > -1;
    }).parent('li').addClass('current-page').parents('ul').slideDown(function() {

    }).parent().addClass('active');
</script>