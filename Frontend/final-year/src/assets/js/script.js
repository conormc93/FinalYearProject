
var myApp = angular.module("myApp", []);

myApp.controller("myCtrl", function($scope){
    
  // JQuery example
var $amount = $('.amount');
var $cost = $('.cost');
var $total = $('.total');

$amount.on('input', function(event){
  parseFloat($total.html($amount.val()*$cost.val())).toFixed(2);
});

});