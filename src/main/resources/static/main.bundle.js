webpackJsonp(["main"],{

/***/ "../../../../../src/$$_lazy_route_resource lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "../../../../../src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "../../../../../src/app/about/about.component.html":
/***/ (function(module, exports) {

module.exports = "<h2>What's this</h2>\n<br>\n<p>Here it's explained what is the idea of this software and how to use it in order to be useful...</p>\n"

/***/ }),

/***/ "../../../../../src/app/about/about.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/about/about.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AboutComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var AboutComponent = /** @class */ (function () {
    function AboutComponent() {
    }
    AboutComponent.prototype.ngOnInit = function () {
    };
    AboutComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-about',
            template: __webpack_require__("../../../../../src/app/about/about.component.html"),
            styles: [__webpack_require__("../../../../../src/app/about/about.component.scss")]
        }),
        __metadata("design:paramtypes", [])
    ], AboutComponent);
    return AboutComponent;
}());



/***/ }),

/***/ "../../../../../src/app/app-routing.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppRoutingModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__home_home_component__ = __webpack_require__("../../../../../src/app/home/home.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__about_about_component__ = __webpack_require__("../../../../../src/app/about/about.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__sign_up_sign_up_component__ = __webpack_require__("../../../../../src/app/sign-up/sign-up.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__login_login_component__ = __webpack_require__("../../../../../src/app/login/login.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__business_business_component__ = __webpack_require__("../../../../../src/app/business/business.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__auth_auth_guard_service__ = __webpack_require__("../../../../../src/app/auth/auth.guard.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__location_location_component__ = __webpack_require__("../../../../../src/app/location/location.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__service_service_component__ = __webpack_require__("../../../../../src/app/service/service.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__business_info_business_info_component__ = __webpack_require__("../../../../../src/app/business-info/business-info.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__location_info_location_info_component__ = __webpack_require__("../../../../../src/app/location-info/location-info.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__service_info_service_info_component__ = __webpack_require__("../../../../../src/app/service-info/service-info.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};













var routes = [
    {
        path: '',
        component: __WEBPACK_IMPORTED_MODULE_2__home_home_component__["a" /* HomeComponent */]
    },
    {
        path: 'about',
        component: __WEBPACK_IMPORTED_MODULE_3__about_about_component__["a" /* AboutComponent */]
    },
    {
        path: 'sign-up',
        component: __WEBPACK_IMPORTED_MODULE_4__sign_up_sign_up_component__["a" /* SignUpComponent */]
    },
    {
        path: 'login',
        component: __WEBPACK_IMPORTED_MODULE_5__login_login_component__["a" /* LoginComponent */]
    },
    {
        path: 'businesses',
        component: __WEBPACK_IMPORTED_MODULE_6__business_business_component__["a" /* BusinessComponent */],
        canActivate: [__WEBPACK_IMPORTED_MODULE_7__auth_auth_guard_service__["a" /* AuthGuardService */]]
    },
    {
        path: 'locations',
        component: __WEBPACK_IMPORTED_MODULE_8__location_location_component__["a" /* LocationComponent */],
        canActivate: [__WEBPACK_IMPORTED_MODULE_7__auth_auth_guard_service__["a" /* AuthGuardService */]]
    },
    {
        path: 'services',
        component: __WEBPACK_IMPORTED_MODULE_9__service_service_component__["a" /* ServiceComponent */],
        canActivate: [__WEBPACK_IMPORTED_MODULE_7__auth_auth_guard_service__["a" /* AuthGuardService */]]
    },
    {
        path: 'business-info',
        component: __WEBPACK_IMPORTED_MODULE_10__business_info_business_info_component__["a" /* BusinessInfoComponent */]
    },
    {
        path: 'location-info',
        component: __WEBPACK_IMPORTED_MODULE_11__location_info_location_info_component__["a" /* LocationInfoComponent */]
    },
    {
        path: 'service-info',
        component: __WEBPACK_IMPORTED_MODULE_12__service_info_service_info_component__["a" /* ServiceInfoComponent */]
    }
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
            imports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* RouterModule */].forRoot(routes)],
            exports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* RouterModule */]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "../../../../../src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<!--The content below is only a placeholder and can be replaced.-->\n<mat-toolbar color=\"primary\">\n  <mat-toolbar-row>\n    <span>Easybooker</span>\n\n    <span class=\"example-spacer\"></span>\n\n    <ng-container *ngIf=\"!this.authService.isAuthenticated()\">\n      <button mat-button routerLink=\"\">Home</button>\n      <button mat-button routerLink=\"about\">What's this</button>\n      <button mat-button routerLink=\"sign-up\" >Sign up</button>\n      <button mat-button routerLink=\"login\">Log in</button>\n    </ng-container>\n\n    <ng-container *ngIf=\"this.authService.isAuthenticated()\">\n      <button mat-button routerLink=\"\">Home</button>\n      <button mat-button routerLink=\"businesses\" >Add business</button>\n      <button mat-button (click)=\"removeToken()\">Log out</button>\n    </ng-container>\n  </mat-toolbar-row>\n</mat-toolbar>\n\n<router-outlet></router-outlet>\n"

/***/ }),

/***/ "../../../../../src/app/app.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".example-icon {\n  padding: 0 14px; }\n\n.example-spacer {\n  -webkit-box-flex: 1;\n      -ms-flex: 1 1 auto;\n          flex: 1 1 auto; }\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__auth_auth_service__ = __webpack_require__("../../../../../src/app/auth/auth.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var AppComponent = /** @class */ (function () {
    function AppComponent(authService, router) {
        this.authService = authService;
        this.router = router;
        this.title = 'app';
    }
    AppComponent.prototype.ngOnInit = function () {
    };
    AppComponent.prototype.removeToken = function () {
        console.log(this.authService.isAuthenticated());
        localStorage.removeItem('token');
        console.log(this.authService.isAuthenticated());
        this.router.navigate(['']);
    };
    AppComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-root',
            template: __webpack_require__("../../../../../src/app/app.component.html"),
            styles: [__webpack_require__("../../../../../src/app/app.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__auth_auth_service__["a" /* AuthService */], __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* Router */]])
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "../../../../../src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("../../../platform-browser/esm5/platform-browser.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__app_routing_module__ = __webpack_require__("../../../../../src/app/app-routing.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__app_component__ = __webpack_require__("../../../../../src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__home_home_component__ = __webpack_require__("../../../../../src/app/home/home.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__about_about_component__ = __webpack_require__("../../../../../src/app/about/about.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_platform_browser_animations__ = __webpack_require__("../../../platform-browser/esm5/animations.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__sign_up_sign_up_component__ = __webpack_require__("../../../../../src/app/sign-up/sign-up.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__login_login_component__ = __webpack_require__("../../../../../src/app/login/login.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__business_business_component__ = __webpack_require__("../../../../../src/app/business/business.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__location_location_component__ = __webpack_require__("../../../../../src/app/location/location.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__auth_auth_component__ = __webpack_require__("../../../../../src/app/auth/auth.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__auth_token_interceptor__ = __webpack_require__("../../../../../src/app/auth/token.interceptor.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15__auth_auth_service__ = __webpack_require__("../../../../../src/app/auth/auth.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_16__auth_auth_guard_service__ = __webpack_require__("../../../../../src/app/auth/auth.guard.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_17__service_service_component__ = __webpack_require__("../../../../../src/app/service/service.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_18__services_message_service__ = __webpack_require__("../../../../../src/app/services/message.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_19__business_info_business_info_component__ = __webpack_require__("../../../../../src/app/business-info/business-info.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_20__services_business_info_service__ = __webpack_require__("../../../../../src/app/services/business.info.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_21__services_upload_service__ = __webpack_require__("../../../../../src/app/services/upload.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_22__location_info_location_info_component__ = __webpack_require__("../../../../../src/app/location-info/location-info.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_23__service_info_service_info_component__ = __webpack_require__("../../../../../src/app/service-info/service-info.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_24__material_module__ = __webpack_require__("../../../../../src/app/material.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_25__primeng_module__ = __webpack_require__("../../../../../src/app/primeng.module.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



























var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["NgModule"])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_4__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_5__home_home_component__["a" /* HomeComponent */],
                __WEBPACK_IMPORTED_MODULE_6__about_about_component__["a" /* AboutComponent */],
                __WEBPACK_IMPORTED_MODULE_8__sign_up_sign_up_component__["a" /* SignUpComponent */],
                __WEBPACK_IMPORTED_MODULE_9__login_login_component__["a" /* LoginComponent */],
                __WEBPACK_IMPORTED_MODULE_11__business_business_component__["a" /* BusinessComponent */],
                __WEBPACK_IMPORTED_MODULE_12__location_location_component__["a" /* LocationComponent */],
                __WEBPACK_IMPORTED_MODULE_13__auth_auth_component__["a" /* AuthComponent */],
                __WEBPACK_IMPORTED_MODULE_17__service_service_component__["a" /* ServiceComponent */],
                __WEBPACK_IMPORTED_MODULE_19__business_info_business_info_component__["a" /* BusinessInfoComponent */],
                __WEBPACK_IMPORTED_MODULE_22__location_info_location_info_component__["a" /* LocationInfoComponent */],
                __WEBPACK_IMPORTED_MODULE_23__service_info_service_info_component__["a" /* ServiceInfoComponent */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["BrowserModule"],
                __WEBPACK_IMPORTED_MODULE_3__app_routing_module__["a" /* AppRoutingModule */],
                __WEBPACK_IMPORTED_MODULE_2__angular_forms__["c" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_7__angular_platform_browser_animations__["a" /* BrowserAnimationsModule */],
                __WEBPACK_IMPORTED_MODULE_24__material_module__["a" /* MaterialModule */],
                __WEBPACK_IMPORTED_MODULE_2__angular_forms__["h" /* ReactiveFormsModule */],
                __WEBPACK_IMPORTED_MODULE_10__angular_common_http__["c" /* HttpClientModule */],
                __WEBPACK_IMPORTED_MODULE_25__primeng_module__["a" /* PrimengModule */]
            ],
            providers: [
                {
                    provide: __WEBPACK_IMPORTED_MODULE_10__angular_common_http__["a" /* HTTP_INTERCEPTORS */],
                    useClass: __WEBPACK_IMPORTED_MODULE_14__auth_token_interceptor__["a" /* TokenInterceptor */],
                    multi: true
                }, __WEBPACK_IMPORTED_MODULE_15__auth_auth_service__["a" /* AuthService */],
                __WEBPACK_IMPORTED_MODULE_16__auth_auth_guard_service__["a" /* AuthGuardService */],
                __WEBPACK_IMPORTED_MODULE_18__services_message_service__["a" /* CreateBusinessService */],
                __WEBPACK_IMPORTED_MODULE_20__services_business_info_service__["a" /* BusinessInfoService */],
                __WEBPACK_IMPORTED_MODULE_21__services_upload_service__["a" /* UploadService */]
            ],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_4__app_component__["a" /* AppComponent */]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "../../../../../src/app/auth/auth.component.html":
/***/ (function(module, exports) {

module.exports = "<p>\n  auth works!\n</p>\n"

/***/ }),

/***/ "../../../../../src/app/auth/auth.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/auth/auth.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AuthComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var AuthComponent = /** @class */ (function () {
    function AuthComponent() {
    }
    AuthComponent.prototype.ngOnInit = function () {
    };
    AuthComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-auth',
            template: __webpack_require__("../../../../../src/app/auth/auth.component.html"),
            styles: [__webpack_require__("../../../../../src/app/auth/auth.component.scss")]
        }),
        __metadata("design:paramtypes", [])
    ], AuthComponent);
    return AuthComponent;
}());



/***/ }),

/***/ "../../../../../src/app/auth/auth.guard.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AuthGuardService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__auth_service__ = __webpack_require__("../../../../../src/app/auth/auth.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var AuthGuardService = /** @class */ (function () {
    function AuthGuardService(auth, router) {
        this.auth = auth;
        this.router = router;
    }
    AuthGuardService.prototype.canActivate = function () {
        if (this.auth.isAuthenticated()) {
            return true;
        }
        else {
            console.log('Token expired or not valid');
            localStorage.removeItem('token');
            this.router.navigate(['']);
            return false;
        }
    };
    AuthGuardService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__auth_service__["a" /* AuthService */], __WEBPACK_IMPORTED_MODULE_1__angular_router__["a" /* Router */]])
    ], AuthGuardService);
    return AuthGuardService;
}());



/***/ }),

/***/ "../../../../../src/app/auth/auth.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AuthService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AuthService = /** @class */ (function () {
    function AuthService() {
        this.cachedRequests = [];
    }
    AuthService.prototype.collectFailedRequest = function (request) {
        this.cachedRequests.push(request);
    };
    AuthService.prototype.retryFailedRequests = function () {
        // retry the requests. this method can
        // be called after the token is refreshed
    };
    AuthService.prototype.getToken = function () {
        return localStorage.getItem('token');
    };
    AuthService.prototype.isAuthenticated = function () {
        var token = this.getToken();
        if (token != null) {
            return true;
        }
        else {
            return false;
        }
    };
    AuthService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])()
    ], AuthService);
    return AuthService;
}());



/***/ }),

/***/ "../../../../../src/app/auth/token.interceptor.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TokenInterceptor; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__auth_service__ = __webpack_require__("../../../../../src/app/auth/auth.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__services_message_service__ = __webpack_require__("../../../../../src/app/services/message.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var TokenInterceptor = /** @class */ (function () {
    function TokenInterceptor(auth, createBusinessService) {
        this.auth = auth;
        this.createBusinessService = createBusinessService;
    }
    TokenInterceptor.prototype.intercept = function (request, next) {
        request = request.clone({
            setHeaders: {
                Authorization: "" + this.auth.getToken(),
                businessId: "" + this.createBusinessService.getBusinessId()
            }
        });
        return next.handle(request);
    };
    TokenInterceptor = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__auth_service__["a" /* AuthService */], __WEBPACK_IMPORTED_MODULE_2__services_message_service__["a" /* CreateBusinessService */]])
    ], TokenInterceptor);
    return TokenInterceptor;
}());



/***/ }),

/***/ "../../../../../src/app/business-info/business-info.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-card>\r\n  <mat-card-content>\r\n    <h2 class=\"example-h2\">{{business.name}}</h2>\r\n    <mat-tab-group class=\"demo-tab-group\">\r\n      <mat-tab label=\"Business info\">\r\n        <div class=\"demo-tab-content\">\r\n          {{business.summary}}\r\n          <br>\r\n          <br>\r\n          <p> Email: {{business.email}} </p>\r\n        </div>\r\n      </mat-tab>\r\n      <mat-tab label=\"Locations\">\r\n        <div class=\"col\">\r\n        <span *ngFor=\"let location of locations\">\r\n          <button mat-raised-button (click)=\"showLocation(location)\">{{location['address']}}</button> <br>\r\n        </span>\r\n        </div>\r\n      </mat-tab>\r\n      <mat-tab label=\"Services\">\r\n        <div class=\"col\">\r\n        <span *ngFor=\"let service of services\">\r\n          <button mat-raised-button >{{service['name']}} timeDuration: {{(service['timeDuration'])['hours']}}</button> <br>\r\n        </span>\r\n        </div>\r\n      </mat-tab>\r\n      <mat-tab label=\"Employees\">\r\n        No content\r\n      </mat-tab>\r\n\r\n    </mat-tab-group>\r\n  </mat-card-content>\r\n</mat-card>\r\n"

/***/ }),

/***/ "../../../../../src/app/business-info/business-info.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/business-info/business-info.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return BusinessInfoComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__services_business_info_service__ = __webpack_require__("../../../../../src/app/services/business.info.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__auth_auth_service__ = __webpack_require__("../../../../../src/app/auth/auth.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var BusinessInfoComponent = /** @class */ (function () {
    function BusinessInfoComponent(httpClient, router, authService, businessInfoService) {
        this.httpClient = httpClient;
        this.router = router;
        this.authService = authService;
        this.businessInfoService = businessInfoService;
    }
    BusinessInfoComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.business = this.businessInfoService.getCurrentBusiness();
        this.httpClient.get('http://localhost:8080/businesses/'
            + this.businessInfoService.getCurrentBusiness()['id'] + "/services", { observe: 'response' }).subscribe(function (resp) {
            _this.services = resp.body;
            console.log(resp.body.toString());
            console.log(resp.body);
        });
        this.httpClient.get('http://localhost:8080/businesses/'
            + this.businessInfoService.getCurrentBusiness()['id'] + "/locations", { observe: 'response' }).subscribe(function (resp) {
            _this.locations = resp.body;
        });
    };
    BusinessInfoComponent.prototype.showLocation = function (location) {
        this.businessInfoService.setCurrentLocation(location);
        this.router.navigate(['location-info']);
    };
    BusinessInfoComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-business-info',
            template: __webpack_require__("../../../../../src/app/business-info/business-info.component.html"),
            styles: [__webpack_require__("../../../../../src/app/business-info/business-info.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["b" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_4__angular_router__["a" /* Router */],
            __WEBPACK_IMPORTED_MODULE_3__auth_auth_service__["a" /* AuthService */], __WEBPACK_IMPORTED_MODULE_2__services_business_info_service__["a" /* BusinessInfoService */]])
    ], BusinessInfoComponent);
    return BusinessInfoComponent;
}());



/***/ }),

/***/ "../../../../../src/app/business/business.component.html":
/***/ (function(module, exports) {

module.exports = "\n<h2>Add new business</h2>\n<br>\n\n\n\n\n\n\n<!--<p-growl [value]=\"msgs\"></p-growl>-->\n\n<!--<h3 class=\"first\">Advanced</h3>-->\n<!--<p-fileUpload name=\"demo[]\" url=\"./upload.php\" (onUpload)=\"onUpload($event)\"-->\n              <!--multiple=\"multiple\" accept=\"image/*\" maxFileSize=\"1000000\">-->\n  <!--<ng-template pTemplate=\"content\">-->\n    <!--<ul *ngIf=\"uploadedFiles.length\">-->\n      <!--<li *ngFor=\"let file of uploadedFiles\">{{file.name}} - {{file.size}} bytes</li>-->\n    <!--</ul>-->\n  <!--</ng-template>-->\n<!--</p-fileUpload>-->\n\n<!--<h3>Basic</h3>-->\n<!--<p-fileUpload mode=\"basic\" name=\"demo[]\" url=\"./upload.php\" accept=\"image/*\" maxFileSize=\"1000000\" (onUpload)=\"onBa\n<h3>Basic with Auto</h3>sicUpload($event)\"></p-fileUpload>-->\n\n<!--<p-fileUpload #fubauto mode=\"basic\" name=\"demo[]\" url=\"./upload.php\" accept=\"image/*\" maxFileSize=\"1000000\" (onUpload)=\"onBasicUploadAuto($event)\" auto=\"true\" chooseLabel=\"Browse\"></p-fileUpload>-->\n\n\n\n\n\n\n\n\n\n<br>\n\n<div class=\"easybooker-div\">\n\n  <form>\n\n    <!--<p-fileUpload name=\"image\" url=\"http://localhost:8080/businesses/5/images\" method=\"POST\">Upload</p-fileUpload>-->\n    <input style=\"display: none\" type=\"file\" (change)=\"onFileSelected($event)\" #fileInput>\n    <button mat-raised-button (click)=\"fileInput.click()\">Pick an image</button>\n    <!--<button mat-raised-button (click)=\"onUpload()\" >Upload</button>-->\n\n\n    <mat-form-field class=\"example-full-width\">\n      <input matInput  type=\"text\" placeholder=\"Name\" name=\"name\" [(ngModel)]=\"business['name']\" />\n    </mat-form-field>\n\n    <mat-form-field class=\"example-full-width\">\n      <input matInput  type=\"text\" placeholder=\"Summary\" name=\"summary\" [(ngModel)]=\"business['summary']\"/>\n    </mat-form-field>\n\n    <mat-form-field class=\"example-full-width\">\n      <input matInput  type=\"text\" placeholder=\"Email Address\" name=\"email\" [(ngModel)]=\"business['email']\"/>\n    </mat-form-field>\n\n    <br/>\n\n\n    <button mat-raised-button (click)=\"addBusiness()\">Create business</button>\n    <mat-spinner [style.display]=\"showSpinner ? 'block' : 'none'\"></mat-spinner>\n\n  </form>\n\n\n  </div>\n"

/***/ }),

/***/ "../../../../../src/app/business/business.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/business/business.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return BusinessComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_message_service__ = __webpack_require__("../../../../../src/app/services/message.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var BusinessComponent = /** @class */ (function () {
    function BusinessComponent(httpClient, router, createBusinessService) {
        this.httpClient = httpClient;
        this.router = router;
        this.createBusinessService = createBusinessService;
        this.business = {
            name: '',
            summary: '',
            email: ''
        };
        this.selectedFile = null;
        // answerDisplay: string = '';
        this.showSpinner = false;
    }
    BusinessComponent.prototype.ngOnInit = function () {
    };
    BusinessComponent.prototype.onFileSelected = function (event) {
        this.selectedFile = event.target.files[0];
    };
    BusinessComponent.prototype.addBusiness = function () {
        var _this = this;
        this.showSpinner = true;
        this.httpClient.post('http://localhost:8080/businesses', this.business, { observe: 'response' }).subscribe(function (resp) {
            _this.createBusinessService.setBusinessId(resp.body["id"]);
            if (_this.selectedFile) {
                var fd_1 = new FormData();
                fd_1.append('image', _this.selectedFile, _this.selectedFile.name);
                _this.httpClient.post('http://localhost:8080/businesses/' + resp.body["id"] + '/images', fd_1).subscribe(function (resp) {
                    console.log(fd_1);
                });
            }
            _this.router.navigate(['/services']);
        });
        setTimeout(function () {
            // this.answerDisplay = this.name;
            _this.showSpinner = false;
        }, 2000);
    };
    BusinessComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-business',
            template: __webpack_require__("../../../../../src/app/business/business.component.html"),
            styles: [__webpack_require__("../../../../../src/app/business/business.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["b" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* Router */], __WEBPACK_IMPORTED_MODULE_3__services_message_service__["a" /* CreateBusinessService */]])
    ], BusinessComponent);
    return BusinessComponent;
}());



/***/ }),

/***/ "../../../../../src/app/home/home.component.html":
/***/ (function(module, exports) {

module.exports = "<h2>EasyBooker makes booking easier than ever ! </h2>\r\n<mat-card>\r\n  <mat-card-content>\r\n    <mat-tab-group class=\"demo-tab-group\">\r\n      <mat-tab label=\"Businesses\">\r\n        <div class=\"col\">\r\n          <p class=\"life-container\" *ngFor=\"let business of businesses\">\r\n            <img src='http://localhost:8080/images/businesses/2/lulin.PNG'/>\r\n\r\n            <iframe width=\"100%\" height=\"550px\" src=\"src/main/resources/static/images/businesses/2/lulin.PNG\"></iframe>\r\n\r\n            <button mat-raised-button (click)=\"showBusiness(business)\">{{business.name}}</button>\r\n            <mat-spinner [style.display]=\"showSpinner ? 'block' : 'none'\"></mat-spinner>\r\n          </p>\r\n        </div>\r\n      </mat-tab>\r\n      <mat-tab label=\"Locations\">\r\n        <div class=\"col\">\r\n        <span *ngFor=\"let location of locations\">\r\n          <button mat-raised-button (click)=\"showLocation(location)\">{{location['address']}}</button> <br>\r\n        </span>\r\n        </div>\r\n      </mat-tab>\r\n      <mat-tab label=\"Services\">\r\n        <div class=\"col\">\r\n        <span *ngFor=\"let service of services\">\r\n          <button mat-raised-button (click)=\"showService(service)\">{{service['name']}}\r\n            timeDuration: {{(service['timeDuration'])['hours']}}</button> <br>\r\n        </span>\r\n        </div>\r\n      </mat-tab>\r\n\r\n\r\n    </mat-tab-group>\r\n  </mat-card-content>\r\n</mat-card>\r\n"

/***/ }),

/***/ "../../../../../src/app/home/home.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/home/home.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HomeComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__auth_auth_service__ = __webpack_require__("../../../../../src/app/auth/auth.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_business_info_service__ = __webpack_require__("../../../../../src/app/services/business.info.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var HomeComponent = /** @class */ (function () {
    function HomeComponent(httpClient, router, authService, businessInfoService) {
        this.httpClient = httpClient;
        this.router = router;
        this.authService = authService;
        this.businessInfoService = businessInfoService;
        this.itemCount = 4;
        this.btnText = "Add an item";
        this.goalText = "My first goal...";
        this.goals = ['asdasd', 'anotherThing'];
        this.image = null;
    }
    HomeComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.httpClient.get('http://localhost:8080/images/businesses/2/lulin.PNG')
            .subscribe(function (resp) {
            console.log(resp);
        });
        this.itemCount = this.goals.length;
        this.httpClient.get('http://localhost:8080/businesses', { observe: 'response' })
            .subscribe(function (resp) {
            console.log(resp.headers);
            console.log(resp.body);
            _this.businesses = resp.body;
        });
        this.httpClient.get('http://localhost:8080/locations', { observe: 'response' })
            .subscribe(function (resp) {
            console.log(resp.headers);
            console.log(resp.body);
            _this.locations = resp.body;
        });
        this.httpClient.get('http://localhost:8080/services', { observe: 'response' })
            .subscribe(function (resp) {
            console.log(resp.headers);
            console.log(resp.body);
            _this.services = resp.body;
        });
    };
    HomeComponent.prototype.showBusiness = function (business) {
        console.log(business);
        this.businessInfoService.setCurrentBusiness(business);
        this.router.navigate(['business-info']);
    };
    HomeComponent.prototype.showLocation = function (location) {
        this.businessInfoService.setCurrentLocation(location);
        this.router.navigate(['location-info']);
    };
    HomeComponent.prototype.showService = function (service) {
        this.businessInfoService.setCurrentService(service);
        this.businessInfoService.clearCurrentLocation();
        this.router.navigate(['service-info']);
    };
    HomeComponent.prototype.addItem = function () {
        this.goals.push(this.goalText);
        this.goalText = "";
        this.itemCount = this.goals.length;
    };
    HomeComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-home',
            template: __webpack_require__("../../../../../src/app/home/home.component.html"),
            styles: [__webpack_require__("../../../../../src/app/home/home.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["b" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_4__angular_router__["a" /* Router */],
            __WEBPACK_IMPORTED_MODULE_2__auth_auth_service__["a" /* AuthService */], __WEBPACK_IMPORTED_MODULE_3__services_business_info_service__["a" /* BusinessInfoService */]])
    ], HomeComponent);
    return HomeComponent;
}());



/***/ }),

/***/ "../../../../../src/app/location-info/location-info.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-card>\r\n  <mat-card-content>\r\n    <button mat-raised-button (click)=\"goToBusiness()\">Go to business</button>\r\n    <h2 class=\"example-h2\">{{location.address}}</h2>\r\n    <mat-tab-group class=\"demo-tab-group\">\r\n      <mat-tab label=\"Location info\">\r\n        <div class=\"demo-tab-content\">\r\n          {{location.summary}}\r\n          <br>\r\n          <br>\r\n          <p> Email: {{location.email}} </p>\r\n        </div>\r\n      </mat-tab>\r\n      <mat-tab label=\"Day schedule\">\r\n        <div class=\"col\">\r\n        <span *ngFor=\"let scheduleOfDay of scheduleOfDays\">\r\n          <button mat-raised-button >{{location['openTime']}}</button> <br>\r\n        </span>\r\n        </div>\r\n      </mat-tab>\r\n      <mat-tab label=\"Services\">\r\n        <div class=\"col\">\r\n        <span *ngFor=\"let service of services\">\r\n          <button mat-raised-button (click)=\"showService(service)\">{{service['name']}}\r\n            timeDuration: {{(service['timeDuration'])['hours']}}</button> <br>\r\n        </span>\r\n        </div>\r\n      </mat-tab>\r\n\r\n    </mat-tab-group>\r\n  </mat-card-content>\r\n</mat-card>\r\n\r\n<ng-container *ngIf=\"this.businessInfoService.getCurrentService()\">\r\n  <button mat-button>BOOK IT !</button>\r\n</ng-container>\r\n"

/***/ }),

/***/ "../../../../../src/app/location-info/location-info.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/location-info/location-info.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LocationInfoComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__services_business_info_service__ = __webpack_require__("../../../../../src/app/services/business.info.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__auth_auth_service__ = __webpack_require__("../../../../../src/app/auth/auth.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var LocationInfoComponent = /** @class */ (function () {
    function LocationInfoComponent(httpClient, router, authService, businessInfoService) {
        this.httpClient = httpClient;
        this.router = router;
        this.authService = authService;
        this.businessInfoService = businessInfoService;
    }
    LocationInfoComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.location = this.businessInfoService.getCurrentLocation();
        this.httpClient.get('http://localhost:8080/locations/'
            + this.businessInfoService.getCurrentLocation()['id'] + "/services", { observe: 'response' }).subscribe(function (resp) {
            _this.services = resp.body;
            console.log(resp.body.toString());
            console.log(resp.body);
        });
    };
    LocationInfoComponent.prototype.goToBusiness = function () {
        var _this = this;
        this.httpClient.get('http://localhost:8080/locations/'
            + this.businessInfoService.getCurrentLocation()['id'] + "/business", { observe: 'response' }).subscribe(function (resp) {
            _this.businessInfoService.setCurrentBusiness(resp.body);
            _this.router.navigate(['business-info']);
        });
    };
    LocationInfoComponent.prototype.showService = function (service) {
        this.businessInfoService.setCurrentService(service);
        this.router.navigate(['service-info']);
    };
    LocationInfoComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-location-info',
            template: __webpack_require__("../../../../../src/app/location-info/location-info.component.html"),
            styles: [__webpack_require__("../../../../../src/app/location-info/location-info.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["b" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_4__angular_router__["a" /* Router */],
            __WEBPACK_IMPORTED_MODULE_3__auth_auth_service__["a" /* AuthService */], __WEBPACK_IMPORTED_MODULE_2__services_business_info_service__["a" /* BusinessInfoService */]])
    ], LocationInfoComponent);
    return LocationInfoComponent;
}());



/***/ }),

/***/ "../../../../../src/app/location/location.component.html":
/***/ (function(module, exports) {

module.exports = "<h2>Add locations to the business</h2>\n<br>\n\n<div class=\"easybooker-div\">\n<form>\n\n  <mat-form-field class=\"example-full-width\">\n    <input matInput  type=\"text\" placeholder=\"Address\" name=\"locationAddress\" [(ngModel)]=\"location['address']\" />\n  </mat-form-field>\n\n  <mat-form-field class=\"example-full-width\">\n    <input matInput  type=\"text\" placeholder=\"Summary\" name=\"serviceSummary\" [(ngModel)]=\"location['summary']\"/>\n  </mat-form-field>\n\n  <mat-form-field class=\"example-full-width\">\n    <input matInput  type=\"text\" placeholder=\"Number\" name=\"locationNumber\" [(ngModel)]=\"location['number']\"/>\n  </mat-form-field>\n\n  <mat-form-field class=\"example-full-width\">\n    <input matInput  type=\"text\" placeholder=\"Email\" name=\"locationEmail\" [(ngModel)]=\"location['email']\"/>\n  </mat-form-field>\n\n  <div class=\"col\">\n    <span *ngFor=\"let service of services\">\n    <mat-checkbox color=\"warn\"\n                  name=\"{{service['name']}}\"\n                  value=\"{{service['name']}}\"\n                  (change)=\"change($event, service)\">\n         {{service['name']}}\n    </mat-checkbox>\n</span>\n  </div>\n\n  <!--<p> Selected value: {{selectedServices | json}} </p>-->\n\n  <br/>\n\n\n\n  <br>\n\n  <button mat-raised-button (click)=\"addLocation()\">Add location</button>\n  <mat-spinner [style.display]=\"showSpinner ? 'block' : 'none'\"></mat-spinner>\n\n  <button mat-raised-button (click)=\"finish()\">I'm done</button>\n\n\n</form>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/location/location.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/location/location.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LocationComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_message_service__ = __webpack_require__("../../../../../src/app/services/message.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var LocationComponent = /** @class */ (function () {
    function LocationComponent(httpClient, router, createBusinessService) {
        this.httpClient = httpClient;
        this.router = router;
        this.createBusinessService = createBusinessService;
        this.selectedServices = [];
        this.locations = [];
        this.location = {
            address: '',
            summary: '',
            number: '',
            email: ''
        };
        this.showSpinner = false;
    }
    LocationComponent.prototype.change = function (e, service) {
        if (e.checked) {
            this.selectedServices.push(service['id']);
        }
        else {
            var updateItem = this.selectedServices.find(this.findIndexToUpdate, service['name']);
            var index = this.selectedServices.indexOf(updateItem);
            this.selectedServices.splice(index, 1);
        }
    };
    LocationComponent.prototype.findIndexToUpdate = function (service) {
        return service['name'] === this;
    };
    LocationComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.httpClient.get('http://localhost:8080/businesses/'
            + this.createBusinessService.getBusinessId() + "/services", { observe: 'response' }).subscribe(function (resp) {
            _this.services = resp.body;
        });
    };
    LocationComponent.prototype.addLocation = function () {
        var _this = this;
        this.showSpinner = true;
        this.httpClient.post('http://localhost:8080/businesses/'
            + this.createBusinessService.getBusinessId() + '/locations', this.location, { observe: 'response' }).subscribe(function (resp) {
            _this.httpClient.post('http://localhost:8080/locations/' + resp.body["id"] + "/services", _this.selectedServices, { observe: 'response' }).subscribe(function (resp) {
                console.log(resp);
            });
        });
        setTimeout(function () {
            // this.answerDisplay = this.name;
            _this.showSpinner = false;
        }, 2000);
        this.location['address'] = '';
        this.location['summary'] = '';
        this.location['number'] = '';
        this.location['email'] = '';
    };
    LocationComponent.prototype.finish = function () {
        this.router.navigate(['']);
        this.createBusinessService.clearBusinessId();
    };
    LocationComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-location',
            template: __webpack_require__("../../../../../src/app/location/location.component.html"),
            styles: [__webpack_require__("../../../../../src/app/location/location.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["b" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* Router */], __WEBPACK_IMPORTED_MODULE_3__services_message_service__["a" /* CreateBusinessService */]])
    ], LocationComponent);
    return LocationComponent;
}());



/***/ }),

/***/ "../../../../../src/app/login/login.component.html":
/***/ (function(module, exports) {

module.exports = "<h2>Log in from here</h2>\n<br>\n\n<div class=\"easybooker-div\">\n\n  <form>\n\n    <mat-form-field class=\"example-full-width\">\n      <input matInput  type=\"text\" placeholder=\"Username\" name=\"username\" [(ngModel)]=\"username\" />\n    </mat-form-field>\n\n    <mat-form-field class=\"example-full-width\">\n      <input matInput  type=\"password\" placeholder=\"Password\" name=\"password\" [(ngModel)]=\"password\" />\n    </mat-form-field>\n\n    <br/>\n    <br>\n\n    <button mat-raised-button (click)=\"loginUser()\">Log in</button>\n    <mat-spinner [style.display]=\"showSpinner ? 'block' : 'none'\"></mat-spinner>\n\n  </form>\n\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/login/login.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/login/login.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LoginComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var LoginComponent = /** @class */ (function () {
    function LoginComponent(httpClient, router) {
        this.httpClient = httpClient;
        this.router = router;
        this.username = '';
        this.password = '';
        this.showSpinner = false;
    }
    LoginComponent.prototype.ngOnInit = function () {
    };
    LoginComponent.prototype.loginUser = function () {
        var _this = this;
        this.showSpinner = true;
        this.httpClient.post('http://localhost:8080/login', {
            username: this.username,
            password: this.password
        }, { observe: 'response' }).subscribe(function (resp) {
            localStorage.setItem('token', resp.headers.getAll('Authorization').toString());
            _this.router.navigate(['']);
        });
        setTimeout(function () {
            _this.showSpinner = false;
        }, 2000);
    };
    LoginComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-login',
            template: __webpack_require__("../../../../../src/app/login/login.component.html"),
            styles: [__webpack_require__("../../../../../src/app/login/login.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["b" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* Router */]])
    ], LoginComponent);
    return LoginComponent;
}());



/***/ }),

/***/ "../../../../../src/app/material.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MaterialModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_material_checkbox__ = __webpack_require__("../../../material/esm5/checkbox.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_material_tabs__ = __webpack_require__("../../../material/esm5/tabs.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};




var MaterialModule = /** @class */ (function () {
    function MaterialModule() {
    }
    MaterialModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
            imports: [__WEBPACK_IMPORTED_MODULE_1__angular_material__["a" /* MatButtonModule */], __WEBPACK_IMPORTED_MODULE_1__angular_material__["f" /* MatToolbarModule */], __WEBPACK_IMPORTED_MODULE_1__angular_material__["c" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_3__angular_material_tabs__["a" /* MatTabsModule */],
                __WEBPACK_IMPORTED_MODULE_1__angular_material__["e" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_1__angular_material__["d" /* MatProgressSpinnerModule */], __WEBPACK_IMPORTED_MODULE_1__angular_material__["b" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_2__angular_material_checkbox__["a" /* MatCheckboxModule */]],
            exports: [__WEBPACK_IMPORTED_MODULE_1__angular_material__["a" /* MatButtonModule */], __WEBPACK_IMPORTED_MODULE_1__angular_material__["f" /* MatToolbarModule */], __WEBPACK_IMPORTED_MODULE_1__angular_material__["c" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_3__angular_material_tabs__["a" /* MatTabsModule */],
                __WEBPACK_IMPORTED_MODULE_1__angular_material__["e" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_1__angular_material__["d" /* MatProgressSpinnerModule */], __WEBPACK_IMPORTED_MODULE_1__angular_material__["b" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_2__angular_material_checkbox__["a" /* MatCheckboxModule */]],
        })
    ], MaterialModule);
    return MaterialModule;
}());



/***/ }),

/***/ "../../../../../src/app/primeng.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PrimengModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_primeng_fileupload__ = __webpack_require__("../../../../primeng/fileupload.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_primeng_fileupload___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_primeng_fileupload__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var PrimengModule = /** @class */ (function () {
    function PrimengModule() {
    }
    PrimengModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
            imports: [__WEBPACK_IMPORTED_MODULE_1_primeng_fileupload__["FileUploadModule"]],
            exports: [__WEBPACK_IMPORTED_MODULE_1_primeng_fileupload__["FileUploadModule"]],
        })
    ], PrimengModule);
    return PrimengModule;
}());



/***/ }),

/***/ "../../../../../src/app/service-info/service-info.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-card>\r\n  <mat-card-content>\r\n    <button mat-raised-button (click)=\"goToBusiness()\">Go to business</button>\r\n    <h2 class=\"example-h2\">{{service.name}}</h2>\r\n    <mat-tab-group class=\"demo-tab-group\">\r\n      <mat-tab label=\"Service info\">\r\n        <div class=\"demo-tab-content\">\r\n          {{service.summary}}\r\n          <br>\r\n          <br>\r\n          <p> Price: {{service.price}} </p>\r\n          <p> TimeDuration: {{service.timeDuration}} </p>\r\n        </div>\r\n      </mat-tab>\r\n      <mat-tab label=\"Locations\">\r\n        <div class=\"col\">\r\n        <span *ngFor=\"let location of locations\">\r\n           <button mat-raised-button (click)=\"showLocation(location)\">{{location.address}}</button> <br>\r\n        </span>\r\n        </div>\r\n      </mat-tab>\r\n\r\n    </mat-tab-group>\r\n  </mat-card-content>\r\n</mat-card>\r\n\r\n<ng-container *ngIf=\"this.businessInfoService.getCurrentLocation()\">\r\n  <button mat-button>BOOK IT !</button>\r\n</ng-container>\r\n"

/***/ }),

/***/ "../../../../../src/app/service-info/service-info.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/service-info/service-info.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ServiceInfoComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_business_info_service__ = __webpack_require__("../../../../../src/app/services/business.info.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__auth_auth_service__ = __webpack_require__("../../../../../src/app/auth/auth.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var ServiceInfoComponent = /** @class */ (function () {
    function ServiceInfoComponent(httpClient, router, authService, businessInfoService) {
        this.httpClient = httpClient;
        this.router = router;
        this.authService = authService;
        this.businessInfoService = businessInfoService;
    }
    ServiceInfoComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.service = this.businessInfoService.getCurrentService();
        this.httpClient.get('http://localhost:8080/services/'
            + this.businessInfoService.getCurrentService()['id'] + "/locations", { observe: 'response' }).subscribe(function (resp) {
            _this.locations = resp.body;
        });
    };
    ServiceInfoComponent.prototype.goToBusiness = function () {
        var _this = this;
        this.httpClient.get('http://localhost:8080/services/'
            + this.businessInfoService.getCurrentService()['id'] + "/business", { observe: 'response' }).subscribe(function (resp) {
            _this.businessInfoService.setCurrentBusiness(resp.body);
            _this.router.navigate(['business-info']);
        });
    };
    ServiceInfoComponent.prototype.showLocation = function (location) {
        this.businessInfoService.setCurrentLocation(location);
        this.router.navigate(['location-info']);
    };
    ServiceInfoComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-service-info',
            template: __webpack_require__("../../../../../src/app/service-info/service-info.component.html"),
            styles: [__webpack_require__("../../../../../src/app/service-info/service-info.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* Router */],
            __WEBPACK_IMPORTED_MODULE_4__auth_auth_service__["a" /* AuthService */], __WEBPACK_IMPORTED_MODULE_1__services_business_info_service__["a" /* BusinessInfoService */]])
    ], ServiceInfoComponent);
    return ServiceInfoComponent;
}());



/***/ }),

/***/ "../../../../../src/app/service/service.component.html":
/***/ (function(module, exports) {

module.exports = "<h2>Add services to the business</h2>\n<br>\n\n<div class=\"easybooker-div\">\n<form>\n\n  <mat-form-field class=\"example-full-width\">\n    <input matInput  type=\"text\" placeholder=\"Name\" name=\"serviceName\" [(ngModel)]=\"service['name']\" />\n  </mat-form-field>\n\n  <mat-form-field class=\"example-full-width\">\n    <input matInput  type=\"text\" placeholder=\"Summary\" name=\"serviceSummary\" [(ngModel)]=\"service['summary']\"/>\n  </mat-form-field>\n\n  <mat-form-field class=\"example-full-width\">\n    <input matInput  type=\"text\" placeholder=\"Time duration\" name=\"serviceTimeDuration\" [(ngModel)]=\"service['timeDuration']\"/>\n  </mat-form-field>\n\n  <mat-form-field class=\"example-full-width\">\n    <input matInput  type=\"text\" placeholder=\"Price\" name=\"servicePrice\" [(ngModel)]=\"service['price']\"/>\n  </mat-form-field>\n\n  <br/>\n\n  <button mat-raised-button (click)=\"addService()\">Add service</button>\n  <mat-spinner [style.display]=\"showSpinner ? 'block' : 'none'\"></mat-spinner>\n\n  <button mat-raised-button (click)=\"goToLocations()\">Go to locations</button>\n\n</form>\n\n</div>\n\n"

/***/ }),

/***/ "../../../../../src/app/service/service.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/service/service.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ServiceComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_message_service__ = __webpack_require__("../../../../../src/app/services/message.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var ServiceComponent = /** @class */ (function () {
    function ServiceComponent(httpClient, router, createBusinessService) {
        this.httpClient = httpClient;
        this.router = router;
        this.createBusinessService = createBusinessService;
        this.services = [];
        this.service = {
            name: '',
            summary: '',
            timeDuration: '',
            price: ''
        };
        // answerDisplay: string = '';
        this.showSpinner = false;
    }
    ServiceComponent.prototype.addService = function () {
        var _this = this;
        this.showSpinner = true;
        this.httpClient.post('http://localhost:8080/businesses/' +
            this.createBusinessService.getBusinessId() + '/services', this.service, { observe: 'response' }).subscribe(function (resp) {
            console.log(resp);
        });
        setTimeout(function () {
            // this.answerDisplay = this.name;
            _this.showSpinner = false;
        }, 2000);
        this.service['name'] = '';
        this.service['summary'] = '';
        this.service['timeDuration'] = '';
        this.service['price'] = '';
    };
    ServiceComponent.prototype.goToLocations = function () {
        this.router.navigate(['/locations']);
    };
    ServiceComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-service',
            template: __webpack_require__("../../../../../src/app/service/service.component.html"),
            styles: [__webpack_require__("../../../../../src/app/service/service.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_3__angular_router__["a" /* Router */], __WEBPACK_IMPORTED_MODULE_1__services_message_service__["a" /* CreateBusinessService */]])
    ], ServiceComponent);
    return ServiceComponent;
}());



/***/ }),

/***/ "../../../../../src/app/services/business.info.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return BusinessInfoService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var BusinessInfoService = /** @class */ (function () {
    function BusinessInfoService() {
        this.currentBusiness = null;
        this.currentLocation = null;
        this.currentService = null;
    }
    BusinessInfoService.prototype.getCurrentBusiness = function () {
        return this.currentBusiness;
    };
    BusinessInfoService.prototype.setCurrentBusiness = function (business) {
        this.currentBusiness = business;
    };
    BusinessInfoService.prototype.clearCurrentBusiness = function () {
        this.currentBusiness = null;
    };
    BusinessInfoService.prototype.getCurrentLocation = function () {
        return this.currentLocation;
    };
    BusinessInfoService.prototype.setCurrentLocation = function (location) {
        this.currentLocation = location;
    };
    BusinessInfoService.prototype.clearCurrentLocation = function () {
        this.currentLocation = null;
    };
    BusinessInfoService.prototype.getCurrentService = function () {
        return this.currentService;
    };
    BusinessInfoService.prototype.setCurrentService = function (service) {
        this.currentService = service;
    };
    BusinessInfoService.prototype.clearCurrentService = function () {
        this.currentLocation = null;
    };
    BusinessInfoService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])()
    ], BusinessInfoService);
    return BusinessInfoService;
}());



/***/ }),

/***/ "../../../../../src/app/services/message.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CreateBusinessService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var CreateBusinessService = /** @class */ (function () {
    function CreateBusinessService() {
        this.message = '';
        this.businessId = null;
    }
    CreateBusinessService.prototype.setBusinessId = function (value) {
        this.businessId = value;
    };
    CreateBusinessService.prototype.getBusinessId = function () {
        return this.businessId;
    };
    CreateBusinessService.prototype.clearBusinessId = function () {
        this.businessId = null;
    };
    CreateBusinessService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])()
    ], CreateBusinessService);
    return CreateBusinessService;
}());



/***/ }),

/***/ "../../../../../src/app/services/upload.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return UploadService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var UploadService = /** @class */ (function () {
    function UploadService(http) {
        this.http = http;
    }
    // file from event.target.files[0]
    UploadService.prototype.uploadFile = function (url, file) {
        var formData = new FormData();
        formData.append('upload', file);
        var params = new __WEBPACK_IMPORTED_MODULE_1__angular_common_http__["d" /* HttpParams */]();
        var options = {
            params: params,
            reportProgress: true,
        };
        var req = new __WEBPACK_IMPORTED_MODULE_1__angular_common_http__["e" /* HttpRequest */]('POST', url, formData, options);
        return this.http.request(req);
    };
    UploadService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["b" /* HttpClient */]])
    ], UploadService);
    return UploadService;
}());



/***/ }),

/***/ "../../../../../src/app/sign-up/sign-up.component.html":
/***/ (function(module, exports) {

module.exports = "<h2>Sign up now and start the journey of booking</h2>\n<br>\n\n<div class=\"easybooker-div\">\n\n  <form>\n\n    <mat-form-field class=\"example-full-width\">\n      <input matInput  type=\"text\" placeholder=\"First name\" name=\"firstName\" [(ngModel)]=\"user['firstName']\" />\n    </mat-form-field>\n\n    <mat-form-field class=\"example-full-width\">\n      <input matInput  type=\"text\" placeholder=\"Last Name\" name=\"lastName\" [(ngModel)]=\"user['lastName']\"/>\n    </mat-form-field>\n\n    <mat-form-field class=\"example-full-width\">\n      <input matInput  type=\"text\" placeholder=\"Username\" name=\"username\" [(ngModel)]=\"user['username']\" />\n    </mat-form-field>\n\n    <mat-form-field class=\"example-full-width\">\n      <input matInput  type=\"password\" placeholder=\"Password\" name=\"password\" [(ngModel)]=\"user['password']\" />\n    </mat-form-field>\n\n    <mat-form-field class=\"example-full-width\">\n      <input matInput  type=\"password\" placeholder=\"Confirm Password\" name=\"confirmPassword\" [(ngModel)]=\"confirmPassword\"/>\n    </mat-form-field>\n\n    <mat-form-field class=\"example-full-width\">\n      <input matInput  type=\"text\" placeholder=\"Email Address\" name=\"email\" [(ngModel)]=\"user['email']\"/>\n    </mat-form-field>\n\n    <mat-form-field>\n      <mat-select placeholder=\"Gender\">\n        <mat-option *ngFor=\"let gender of genders\" [value]=\"gender.value\">\n          {{ gender.viewValue }}\n        </mat-option>\n      </mat-select>\n    </mat-form-field>\n\n    <!--<mat-form-field class=\"example-full-width\">-->\n      <!--<input matInput  type=\"text\" placeholder=\"Enter number\" name=\"number\" [(ngModel)]=\"number\"/>-->\n    <!--</mat-form-field>-->\n    <br/>\n    <br>\n\n    <button mat-raised-button (click)=\"addUser()\">Sign up</button>\n    <mat-spinner [style.display]=\"showSpinner ? 'block' : 'none'\"></mat-spinner>\n\n    <!--<mat-card *ngIf=\"answerDisplay\">-->\n      <!--<h1>{{ answerDisplay }}, successfully created account.</h1>-->\n    <!--</mat-card>-->\n\n  </form>\n\n\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/sign-up/sign-up.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/sign-up/sign-up.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SignUpComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var SignUpComponent = /** @class */ (function () {
    function SignUpComponent(httpClient, router) {
        this.httpClient = httpClient;
        this.router = router;
        this.genders = [
            { value: 'male', viewValue: 'Male' },
            { value: 'female', viewValue: 'Female' },
            { value: 'other', viewValue: 'Other' }
        ];
        this.user = {
            firstName: '',
            lastName: '',
            username: '',
            password: '',
            email: '',
            number: ''
        };
        this.answerDisplay = '';
        this.showSpinner = false;
    }
    SignUpComponent.prototype.ngOnInit = function () {
    };
    ;
    SignUpComponent.prototype.addUser = function () {
        var _this = this;
        this.showSpinner = true;
        console.log(this.user['firstName']);
        this.httpClient.post('http://localhost:8080/users', this.user, { observe: 'response' }).subscribe(function (resp) {
            console.log(resp.headers);
            console.log(resp.body);
            _this.router.navigate(['/login']);
        });
        setTimeout(function () {
            _this.answerDisplay = _this.user['firstName'];
            _this.showSpinner = false;
        }, 2000);
    };
    SignUpComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-sign-up',
            template: __webpack_require__("../../../../../src/app/sign-up/sign-up.component.html"),
            styles: [__webpack_require__("../../../../../src/app/sign-up/sign-up.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["b" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* Router */]])
    ], SignUpComponent);
    return SignUpComponent;
}());



/***/ }),

/***/ "../../../../../src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
var environment = {
    production: false
};


/***/ }),

/***/ "../../../../../src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("../../../platform-browser-dynamic/esm5/platform-browser-dynamic.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("../../../../../src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_hammerjs__ = __webpack_require__("../../../../hammerjs/hammer.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_hammerjs___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_4_hammerjs__);





if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["enableProdMode"])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("../../../../../src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map