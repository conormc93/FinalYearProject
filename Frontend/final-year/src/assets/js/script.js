
var myApp = angular.module("myApp", []);

myApp.controller("myCtrl", function($scope){
    
  // JQuery example
var $amount = $('.amount');
var $cost = $('.cost');
var $total = $('.total');

$amount.on('input', function(event){
  $total.html($amount.val()*$cost.val());
});

});