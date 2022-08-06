var app = angular.module('app', ['ngRoute','ngResource']);

app.config(function($routeProvider){
    $routeProvider
        .when('/students',{
            templateUrl: 'resources/static/html/students.html',
            controller: 'studentController'
        })
        .when('/subjects',{
            templateUrl: 'resources/static/html/subjects.html',
            controller: 'subjectsController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});