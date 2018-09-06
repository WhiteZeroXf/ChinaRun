/*
    Created on : 12/02/2015, 7:06:03 PM
    Author     : Robin Spark
*/


jQuery(function () {
    //Box 1: reveal immediately - on page load
    //NOTE: id does refer to an element id, It is used to
    //      uniquely refer to the element to be revealed.
    var options1 = {
        id: 'box1'
    };
    $('.box1').initReveal(options1);

    //------------------------
    //Box 2: reveal after specified delay
    var options2 = {
        id: 'box2'
        , delay: 3000
    };
    $('.box2').initReveal(options2);

 
});
