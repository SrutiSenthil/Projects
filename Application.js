var application = angular.module("Application",["ngRoute"]);

application.config(['$routeProvider',function(routeProvider){
	routeProvider.when('/form',{
		templateUrl: 'FormGenerator.html',
		controller: 'FormGeneratorController'
	}).when('/table',{
		templateUrl: 'TableGenerator.html',
		controller: 'TableGeneratorController'
	}).when('/image',{
		templateUrl: 'ImageGenerator.html',
		controller: 'ImageGeneratorController'
	}).when('/link',{
		templateUrl: 'LinkGenerator.html',
		controller: 'LinkGeneratorController'
	}).when('/list',{
		templateUrl: 'ListGenerator.html',
		controller: 'ListGeneratorContoller'
	}).when('/button',{
		templateUrl: 'ButtonGenerator.html',
		controller: "ButtonGeneratorController"
	}).when('/divtable',{
		templateUrl: 'DivTableGenerator.html',
		controller: "DivTableGeneratorController"
	}).when('/dynamic',{
		templateUrl: 'DynamicGenerator.html',
		controller: "DynamicGeneratorController"
	}).otherwise({
		redirectTo: '/'
	});
}]);

//application.config([ '$routeProvider', function(routeProvider) {
//    routeProvider.when('/form', {
//           templateUrl: 'FormGenerator.html',
//           controller: 'FormGeneratorController'
//    }).when('/image', {
//           templateUrl: 'ImageGenerator.html',
//           controller: 'ImageGeneratorController'
//    }).when('/link', {
//           templateUrl: 'LinkGenerator.html',
//           controller: 'LinkGeneratorController'
//    }).when('/list', {
//           templateUrl: 'ListGenerator.html',
//           controller: 'ListGeneratorContoller'
//    }).when('/table', {
//           templateUrl: 'TableGenerator.html',
//           controller: 'TableGeneratorController'
//    }).otherwise({
//           redirectTo: '/'
//    });
//} ]);


var URI = getURI();
