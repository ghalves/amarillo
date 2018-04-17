$(document).on('pageload', function() {
        $('.button-collapse').sideNav();
        $('.collapsible').collapsible();
        $('.tooltipped').tooltip();
        $('input#input_text, textarea#textarea2').characterCounter();
        $('.dropdown-button').dropdown();
});
