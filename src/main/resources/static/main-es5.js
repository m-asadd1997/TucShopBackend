(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"], {
  /***/
  "./$$_lazy_route_resource lazy recursive":
  /*!******************************************************!*\
    !*** ./$$_lazy_route_resource lazy namespace object ***!
    \******************************************************/

  /*! no static exports found */

  /***/
  function $$_lazy_route_resourceLazyRecursive(module, exports, __webpack_require__) {
    var map = {
      "./../app.module": ["./src/app/app.module.ts"],
      "./admins/admins.module": ["./src/app/admins/admins.module.ts", "admins-admins-module"]
    };

    function webpackAsyncContext(req) {
      if (!__webpack_require__.o(map, req)) {
        return Promise.resolve().then(function () {
          var e = new Error("Cannot find module '" + req + "'");
          e.code = 'MODULE_NOT_FOUND';
          throw e;
        });
      }

      var ids = map[req],
          id = ids[0];
      return Promise.all(ids.slice(1).map(__webpack_require__.e)).then(function () {
        return __webpack_require__(id);
      });
    }

    webpackAsyncContext.keys = function webpackAsyncContextKeys() {
      return Object.keys(map);
    };

    webpackAsyncContext.id = "./$$_lazy_route_resource lazy recursive";
    module.exports = webpackAsyncContext;
    /***/
  },

  /***/
  "./node_modules/raw-loader/dist/cjs.js!./src/app/app.component.html":
  /*!**************************************************************************!*\
    !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/app.component.html ***!
    \**************************************************************************/

  /*! exports provided: default */

  /***/
  function node_modulesRawLoaderDistCjsJsSrcAppAppComponentHtml(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony default export */


    __webpack_exports__["default"] = "<router-outlet></router-outlet>";
    /***/
  },

  /***/
  "./node_modules/raw-loader/dist/cjs.js!./src/app/checkout/checkout.component.html":
  /*!****************************************************************************************!*\
    !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/checkout/checkout.component.html ***!
    \****************************************************************************************/

  /*! exports provided: default */

  /***/
  function node_modulesRawLoaderDistCjsJsSrcAppCheckoutCheckoutComponentHtml(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony default export */


    __webpack_exports__["default"] = "<nz-content>\r\n  <nz-breadcrumb> </nz-breadcrumb>\r\n  <div class=\"inner-content\" style=\"margin-top: 10px;\">\r\n\r\n    <div nz-row style=\"margin-left: -25px;\">\r\n      <!-- <div nz-col nzSpan=\"3\">\r\n        <h4><b>Cart: </b></h4>\r\n      </div> -->\r\n      <div nz-col nzSpan=\"2\">\r\n       <img src=\"assets/cartCheckout.png\" />\r\n      </div>\r\n\r\n      <div nz-col nzSpan=\"4\" nzOffset=\"9\">\r\n      <button nz-button nzType=\"danger\" (click)=\"showModal2()\" style=\"margin-left: -10px;\">\r\n        <span>Request For Product</span>\r\n      </button>\r\n\r\n      <nz-modal [(nzVisible)]=\"isVisible1\" nzTitle=\"User Selection\" (nzOnCancel)=\"handleCancel1()\" (nzOnOk)=\"handleOk1()\">\r\n        <link rel=\"stylesheet\" type=\"text/css\" href=\"//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css\">\r\n        <hr>\r\n        <div class=\"container bootstrap snippet\">\r\n            <div class=\"row\">\r\n                <div class=\"col-lg-12\">\r\n                    <div class=\"main-box no-header clearfix\">\r\n                        <div class=\"main-box-body clearfix\">\r\n                            <div class=\"table-responsive\">\r\n                                <table class=\"table user-list\">\r\n                                    <thead>\r\n                                        <tr>\r\n                                        <th><span>User</span></th>\r\n                                        <!-- <th><span>Created</span></th> -->\r\n                                        <th class=\"text-center\"><span>Status</span></th>\r\n                                        <th><span>Email</span></th>\r\n                                        <th>&nbsp;</th>\r\n                                        </tr>\r\n                                    </thead>\r\n                                    <tbody>\r\n                                        <tr *ngFor=\"let item of user\">\r\n                                            <td>\r\n                                                <img src=\"./../../assets/user.png\" alt=\"\">\r\n                                                <a href=\"#\" class=\"user-link\">{{item.name}}</a>\r\n                                                <span class=\"user-subhead\">Office Boy</span>\r\n                                            </td>\r\n                                            <!-- <td>2013/08/12</td> -->\r\n                                            <td class=\"text-center\">\r\n                                                <span class=\"label label-default\">{{item.active}}</span>\r\n                                            </td>\r\n                                            <td>\r\n                                                <a href=\"#\">{{item.email}}</a>\r\n                                            </td>\r\n                                            <td style=\"width: 20%;\">\r\n                                                <button [disabled]=\"buttonDisable\" (click)=\"print(item.name,'ROD')\" nz-button nzType=\"primary\">Request</button>\r\n                                            </td>\r\n                                        </tr>\r\n                                       \r\n                                    </tbody>\r\n                                </table>\r\n                            </div>\r\n                        </div>\r\n                    </div>\r\n                </div>\r\n            </div>\r\n        </div>\r\n        </nz-modal>\r\n        \r\n      \r\n\r\n      <nz-modal\r\n        \r\n        [(nzVisible)]=\"isVisible2\"\r\n        nzTitle=\"Request For Product\"\r\n        (nzOnCancel)=\"handleCancel()\"\r\n        (nzOnOk)=\"postProduct()\"\r\n        [nzOkDisabled]=\"disableButton()\"\r\n        [nzOkLoading]=\"isOkLoading\"\r\n        nzOkText=\"Submit\"\r\n      >\r\n      <!-- <input nz-input placeholder=\"Request For Product\" name=\"requestedProductName\" [(ngModel)]=\"checkOutObj.name\" /> -->\r\n      <div class=\"example-input\">\r\n        <nz-input-group nzSearch nzSize=\"large\" [nzAddOnAfter]=\"suffixIconButton\">\r\n          <input\r\n            placeholder=\"Request For Product\"\r\n            nz-input\r\n            [(ngModel)]=\"checkOutObj.name\"\r\n            (input)=\"onChange($event)\"\r\n            [nzAutocomplete]=\"auto\"\r\n          />\r\n        </nz-input-group>\r\n        <ng-template #suffixIconButton>\r\n          <button nz-button nzType=\"primary\" nzSize=\"large\" nzSearch>\r\n            <i nz-icon nzType=\"search\" nzTheme=\"outline\"></i>\r\n          </button>\r\n        </ng-template>\r\n        <nz-autocomplete #auto>\r\n          <nz-auto-option class=\"global-search-item\" *ngFor=\"let option of options\" [nzValue]=\"option.name\">\r\n            Found &nbsp; <b>{{ option.name | uppercase }}</b> &nbsp; on &nbsp;\r\n           \r\n            <span class=\"global-search-item-count\"><b>{{ option.count }}</b> &nbsp; results</span>\r\n          </nz-auto-option>\r\n        </nz-autocomplete>\r\n      </div>  \r\n    </nz-modal>\r\n    </div>\r\n    </div>\r\n\r\n    <hr style=\"color: black; margin-left: -10px; margin-right: 25px; margin-top: 20px;\" />\r\n\r\n    <div style=\"height: 420px; overflow-y: scroll;\">\r\n     \r\n        <div *ngFor=\"let data of checkoutProductsArray\">\r\n          <nz-card id =\"cardShadow\" nzHoverable style=\"width:100%; margin-bottom: 6px;\">\r\n\r\n            <div nz-row>\r\n              <div nz-col nzSpan=\"4\">\r\n                <nz-badge [nzCount]=\"data.productQuantity\">\r\n                <nz-avatar\r\n                  [nzShape]=\"'square'\"\r\n                  [nzSize]=\"64\"\r\n                  [nzSrc]=\"data.productImage\"\r\n                  [nzIcon]=\"'user'\"\r\n                ></nz-avatar>\r\n              </nz-badge>\r\n              </div>\r\n\r\n              <div nz-col nzSpan=\"6\" nzOffset=\"3\">\r\n                <h4 nz-title style=\"font-size: 15px;\"><b>\r\n                  {{ data.productTitle }}</b>\r\n                  <br>\r\n                  <b style=\"font-size: 11px;\">{{data.productVariant}}  </b><br>\r\n                  <!-- Price: {{ data.productPrice }} -->\r\n                  <nz-tag [nzColor]=\"'#f50a0a'\">Price {{data.productPrice}}</nz-tag>\r\n                </h4>\r\n                \r\n              </div>\r\n\r\n              <!-- <div nz-col nzSpan=\"2\" nzOffset=\"1\">\r\n                <h4 nz-title style=\"font-size: 15px;\">\r\n                  Price: {{ data.productPrice }}\r\n                </h4>\r\n              </div> -->\r\n  \r\n              <div nz-col nzSpan=\"6\" nzOffset=\"2\" style=\"font-size: 15px;\">\r\n                <h4>\r\n                  <!-- Quantity: {{ data.productQuantity }} -->\r\n                  <nz-button-group>\r\n                    <!-- Add Buttons -->\r\n                    <button #btn nz-button  *ngIf=\"checkingQunatity(data)\" (click)=\"addProduct(data)\">\r\n                      <i nz-icon nzType=\"plus\"></i>\r\n                    </button>\r\n\r\n                    <button #btn1 nz-button  disabled *ngIf=\"!checkingQunatity(data)\" >\r\n                      <i nz-icon nzType=\"plus\"></i>\r\n                    </button>\r\n                    <!--End of Add Buttons  -->\r\n\r\n                    <!-- Minus Buttons -->\r\n                    <button     nz-button (click)=\"removeProduct(data)\">\r\n                      <i nz-icon nzType=\"minus\"></i>\r\n                    </button>\r\n                    <!-- End of Minus Buttons -->\r\n                  </nz-button-group>\r\n                </h4>\r\n              </div>\r\n\r\n              <div\r\n                nz-col\r\n                nzSpan=\"2\"\r\n                nzOffset=\"1\"\r\n                (click)=\"removeProductFromCheckout(data)\"\r\n              >\r\n                <img src=\"assets/icons8-delete-bin-24.png\" />\r\n              </div>\r\n           </div>\r\n          </nz-card>\r\n        </div>\r\n    </div>\r\n    <hr style=\"color: black;\" />\r\n    <div nz-row>\r\n      <div nz-col nzSpan=\"12\" style=\"margin-top: 6px;\">\r\n        <h3>\r\n          <b>Total: {{ total }}</b>\r\n        </h3>\r\n      </div>\r\n      <div nz-col nzSpan=\"6\" nzOffset=\"6\" style=\"margin-top: 6px;\">\r\n        <button [disabled]=\"checkoutProductsArray.length==0\" nz-button nzType=\"danger\" (click)=\"showModal()\">\r\n          Checkout\r\n        </button>\r\n        <nz-modal\r\n          [(nzVisible)]=\"isVisible\"\r\n          nzTitle=\"Checkout\"\r\n         \r\n          nzCancelText=\"Continue Shopping \"\r\n         \r\n          (nzOnCancel)=\"handleCancel()\"\r\n        >\r\n        <!--  nzOkText=\"Print\"    (nzOnOk)=\"print()\" -->\r\n          <h4>Please select how you want to checkout</h4>\r\n          <div nz-row style=\"margin-top:22px\">\r\n\r\n\r\n           <div nz-col nzSpan=\"9\" nzOffset=\"3\"> <button (click)=\"print('','SC')\" nz-button nzType=\"primary\">Self Checkout</button></div>\r\n\r\n           <div nz-col nzSpan=\"9\" nzOffset=\"2\">  <button nz-button nzType=\"primary\"(click)=\"showModal1()\" [disabled]=\"true\" >Delievery on Desk</button></div>\r\n          </div>\r\n       \r\n\r\n        </nz-modal>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</nz-content>\r\n\r\n<div id=\"print-section\" [hidden]=\"true\">\r\n<div style=\"text-align: center;\"   >\r\n  <img   *ngIf=\"(chekingSetting && settingHeader   && settingHeader.logo != 'undefined'  )\" [src]=\"settingHeader.logo\" style=\"height: 100px; width: 100px;\" alt=\"Hello\">\r\n</div>\r\n<br> \r\n<div  *ngIf=\"(chekingSetting && settingHeader  && settingHeader.header  != 'undefined')\" style=\"text-align: center; margin-bottom: 50px;\" >\r\n  <!-- <p class=\"bd-highlight font-weight-bold\">{{settingHeader.header}}</px > -->\r\n    <h2 nz-title>{{settingHeader.header}}</h2>\r\n</div>\r\n\r\n  <div class=\"container\">\r\n    <!-- <h2 style=\"text-align: center; margin-bottom: 15px;\">Order Slip</h2> -->\r\n    \r\n    <table class=\"table table-striped\">\r\n      <thead>\r\n        <th *ngFor=\"let col of cols\" style=\"text-align: center; \">\r\n          {{ col.header }}\r\n        </th>\r\n      </thead>\r\n      <tbody>\r\n        <tr *ngFor=\"let data of checkoutProductsArray\" style=\"overflow: auto; \">\r\n          <td>{{ data.productTitle }}</td>\r\n          <td>{{ data.printProductPrice }}</td>\r\n          <td>{{ data.productQuantity }}</td>\r\n          <td>{{ data.productPrice }}</td>\r\n        </tr>\r\n      </tbody>\r\n    </table>\r\n    <div>\r\n      <hr style=\"border:1px solid black;width:100%;\" />\r\n      <span\r\n        ><b> Total: </b> <span style=\"margin-left:83%;\">{{ total }}</span></span\r\n      >\r\n      <hr style=\"border:1px solid black;width:100%;\" />\r\n    </div>\r\n  </div>\r\n\r\n  \r\n    <div *ngIf=\" (chekingSetting && settingHeader  && settingHeader.footer  != 'undefined')\" style=\"text-align: center; margin-top: 70px;\" >\r\n      <!-- <p class=\"bd-highlight font-weight-bold\">{{settingHeader.header}}</px > -->\r\n        <h2 nz-title>{{settingHeader.footer}}</h2>\r\n    \r\n  </div>\r\n</div>\r\n\r\n\r\n";
    /***/
  },

  /***/
  "./node_modules/raw-loader/dist/cjs.js!./src/app/login-page/login-page.component.html":
  /*!********************************************************************************************!*\
    !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/login-page/login-page.component.html ***!
    \********************************************************************************************/

  /*! exports provided: default */

  /***/
  function node_modulesRawLoaderDistCjsJsSrcAppLoginPageLoginPageComponentHtml(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony default export */


    __webpack_exports__["default"] = "<router-outlet></router-outlet>\r\n\r\n\r\n\r\n\r\n<body id=\"body1\" >\r\n<div class=\"container login-container\">\r\n\t<div class=\"row\">\r\n\t\t<div class=\"col-md-8 login-form-1\">\r\n\t\t\t<h1>Recent Transactions</h1>\r\n\t\t\t<app-recent-transactions></app-recent-transactions>\r\n\t\t</div>\r\n\t\t<div *ngIf=\"login\" class=\"col-md-4 login-form-2\">\r\n\t\t\t<h3>Login</h3>\r\n\t\t\t<form #loginForm=\"ngForm\" (ngSubmit)=\"loginSubmit()\">\r\n\t\t\t\t<div class=\"form-group\">\r\n\t\t\t\t\t<input type=\"password\" required [(ngModel)]=\"loginModel.username\" name=\"username\"\r\n\t\t\t\t\t\tclass=\"form-control\" placeholder=\"Your Company ID\" value=\"\" />\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"form-group\" style=\"text-align: center;\">\r\n\t\t\t\t\t<nz-spin *ngIf=\"isLogSpinning\" [nzDelay]=\"500\" nzSimple [nzSize]=\"'large'\"></nz-spin>\r\n\t\t\t\t\t<button *ngIf=\"!isLogSpinning\" style=\"background-color: white;color:black;\" nz-button\r\n\t\t\t\t\t\tnzType=\"primary\" type=\"submit\" name=\"submit\" [disabled]=\"logValidate()\">Login</button>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"form-group\" style=\"text-align: center;\">\r\n\r\n\t\t\t\t\t<a (click)=\"gotoRegister()\" class=\"ForgetPwd\" value=\"Register\">Register</a>\r\n\t\t\t\t</div>\r\n\t\t\t</form>\r\n\t\t</div>\r\n\t\t<div *ngIf=\"register\" class=\"col-md-4 login-form-2\">\r\n\t\t\t<h3>Register</h3>\r\n\t\t\t<form #registerForm=\"ngForm\" (ngSubmit)=\"submit()\">\r\n\r\n\t\t\t\t<div class=\"form-group\">\r\n\t\t\t\t\t<input type=\"text\" required [(ngModel)]=\"registerModel.name\" name=\"name\" class=\"form-control\"\r\n\t\t\t\t\t\tplaceholder=\"Your Full Name\" value=\"\" />\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"form-group\">\r\n\t\t\t\t\t<input type=\"password\" required [(ngModel)]=\"registerModel.email\" name=\"email\" class=\"form-control\"\r\n\t\t\t\t\t\tplaceholder=\"Your Company ID\" value=\"\" />\r\n\t\t\t\t</div>\r\n\r\n\t\t\t\t<div class=\"form-group\" style=\"text-align: center;\">\r\n\t\t\t\t\t<nz-spin *ngIf=\"isRegSpinning\" [nzDelay]=\"500\" [nzSize]=\"'large'\"></nz-spin>\r\n\t\t\t\t\t<button *ngIf=\"!isRegSpinning\" style=\"background-color: white;color:black;\" nz-button\r\n\t\t\t\t\t\tnzType=\"primary\" type=\"submit\" name=\"submit\" [disabled]=\"validate()\">Register</button>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"form-group\" style=\"text-align: center;\">\r\n\r\n\t\t\t\t\t<a (click)=\"gotoLogin()\" class=\"ForgetPwd\" value=\"Login\">Login</a>\r\n\t\t\t\t</div>\r\n\r\n\t\t\t</form>\r\n\t\t</div>\r\n\t</div>\r\n</div>\r\n</body>\r\n\r\n";
    /***/
  },

  /***/
  "./node_modules/raw-loader/dist/cjs.js!./src/app/main-screen/main-screen.component.html":
  /*!**********************************************************************************************!*\
    !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/main-screen/main-screen.component.html ***!
    \**********************************************************************************************/

  /*! exports provided: default */

  /***/
  function node_modulesRawLoaderDistCjsJsSrcAppMainScreenMainScreenComponentHtml(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony default export */


    __webpack_exports__["default"] = "<nz-layout style=\"width: 100%; height: 100%;\">\r\n\r\n  <nz-sider nzCollapsible [(nzCollapsed)]=\"CollapsedNav\" [nzTrigger]=\"null\">\r\n    <div class=\"logo\" style=\"height:50px; background-color:#001529; width: 20px; margin-left: 15px;\">\r\n      <img src=\"assets/main-cart.png\" [routerLink]=\"'/admin/layout'\" />\r\n    </div>\r\n    <ul nz-menu nzTheme=\"dark\" nzMode=\"inline\" [nzInlineCollapsed]=\"isCollapsed\">\r\n      <li nz-menu-item *ngFor=\"let c of categoriesArray\" (click)=\"addCategoryToUrl(c.name)\" nz-popover\r\n        [nzPopoverContent]=\"c.name\" nzPopoverPlacement=\"right\">\r\n        <img [src]=\"c.image\" />\r\n        <!-- <span>{{c.name}}</span> -->\r\n      </li>\r\n    </ul>\r\n  </nz-sider>\r\n\r\n  <nz-layout>\r\n    <nz-content>\r\n\r\n      <div style=\"margin-right: -15px; margin-left: -20px;\">\r\n        <nz-header>\r\n          <ul nz-menu nzTheme=\"light\" nzMode=\"horizontal\" style=\"padding: -2px; margin: auto; height: 55px;\">\r\n            <!-- <nav\r\n            class=\"navbar navbar-light bg-light\"\r\n            style=\"background-color: white !important;height: 50px;;border-top-color: black;border-top-style:solid; border-top-width: thin; border-bottom-style: ridge; box-shadow:0px 5px 5px rgb(179, 179, 179);\"> -->\r\n\r\n            <!-- <div>\r\n              <a > <img src=\"assets/main-cart.png\" alt=\"\"></a>\r\n            </div>\r\n            <div  style=\"cursor: pointer;margin-right:75%;\">\r\n              <button nz-button  (click)=\"navigateBackToHomePage()\">\r\n              Home\r\n            </button>\r\n            </div> -->\r\n            <div style=\"margin-left: 1260px;\">\r\n              <nz-button-group>\r\n                <button nz-button>{{userName}}</button>\r\n                <button nz-button nz-dropdown [nzDropdownMenu]=\"menu2\" nzPlacement=\"bottomRight\">\r\n                  <i nz-icon nzType=\"user\"></i>\r\n                </button>\r\n              </nz-button-group>\r\n              <nz-dropdown-menu #menu2=\"nzDropdownMenu\">\r\n                <ul nz-menu>\r\n                  <li (click)=\"navigateBackToLoginPage()\" nz-menu-item>Log Out</li>\r\n\r\n                </ul>\r\n              </nz-dropdown-menu>\r\n\r\n\r\n            </div>\r\n            <!-- </nav> -->\r\n          </ul>\r\n        </nz-header>\r\n      </div>\r\n\r\n\r\n\r\n\r\n\r\n      <!-- <div nz-row style=\"float: right;\">\r\n          <button nz-button nzType=\"primary\" (click)=\"showModal()\">\r\n              <span>Show Modal</span>\r\n            </button>\r\n            <nz-modal\r\n              [(nzVisible)]=\"isVisible\"\r\n              nzTitle=\"Modal Title\"\r\n              (nzOnCancel)=\"handleCancel()\"\r\n              (nzOnOk)=\"handleOk()\"\r\n              [nzOkLoading]=\"isOkLoading\"\r\n            >\r\n              <p>Modal Content</p>\r\n            </nz-modal>\r\n      </div> -->\r\n\r\n      <div class=\"inner-content\" style=\"height: 100%;\" style=\"margin-left: -15px; margin-right: -15px;\">\r\n        <div nz-col nzSpan=\"16\">\r\n          <app-product-listing></app-product-listing>\r\n        </div>\r\n        <div nz-col nzSpan=\"7\" nzOffset=\"1\">\r\n          <app-checkout></app-checkout>\r\n        </div>\r\n      </div>\r\n      <nz-footer>Implement By Stepway &copy; 2020</nz-footer>\r\n    </nz-content>\r\n  </nz-layout>\r\n</nz-layout>";
    /***/
  },

  /***/
  "./node_modules/raw-loader/dist/cjs.js!./src/app/product-listing/product-listing.component.html":
  /*!******************************************************************************************************!*\
    !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/product-listing/product-listing.component.html ***!
    \******************************************************************************************************/

  /*! exports provided: default */

  /***/
  function node_modulesRawLoaderDistCjsJsSrcAppProductListingProductListingComponentHtml(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony default export */


    __webpack_exports__["default"] = "<div style=\"width: 25%; float:right;\"> \r\n<div class=\"example-input\">\r\n  <nz-input-group nzSize=\"large\" [nzSuffix]=\"suffixIcon\" > \r\n  <input\r\n      placeholder=\"Search Products\"\r\n      nz-input\r\n      [(ngModel)]=\"inputValue\"\r\n      (ngModelChange)=\"onChange($event)\"\r\n      [nzAutocomplete]=\"auto\"\r\n    />\r\n  </nz-input-group>\r\n  <ng-template #suffixIcon>\r\n    <i nz-icon nzType=\"search\"></i>\r\n  </ng-template>\r\n  <nz-autocomplete #auto>\r\n    <nz-auto-option  *ngFor=\"let option of searchProduct\" [nzValue]=\"option.name\">\r\n     <span ><b>Category: {{option.category.name}}</b></span>\r\n      <br>\r\n       <div>\r\n        Item:{{ option.name}}<img style=\"width: 40px; height: 40px; margin-left: 40px;\" [src]=\"option.image\" >\r\n      </div>\r\n     </nz-auto-option>\r\n  </nz-autocomplete>\r\n</div>\r\n<br>\r\n</div>\r\n<h4 style=\"text-transform:capitalize;\">{{categoryHeader}}</h4>\r\n<nz-card style=\"width: 100%; overflow-y: scroll; overflow-x: none; height:500px;\">\r\n  <div nz-row>\r\n    <div nz-col nzXs=\"24\" nzSm=\"24\" nzMd=\"5\" nzLg=\"5\" nzXl=\"5\" nzSpan=\"5\" nzOffset=\"1\" *ngFor=\"let p of productsArray\">\r\n      <nz-card\r\n        #CARD\r\n        nzHoverable\r\n        style=\"width:160px\"\r\n        [nzCover]=\"coverTemplate\"\r\n        [nzSize]=\"small\"\r\n        (click)=\"sendProducttoCheckout(p,CARD)\"\r\n        id =\"cardShadow\"\r\n      >\r\n        <nz-card-meta [nzTitle]=\"\" [nzDescription]=\"\" style=\"text-align: center;\"></nz-card-meta>\r\n          <div class=\"row\">\r\n              <div style=\"margin-left: 0px;\"><b>{{p.name | uppercase}}</b></div>\r\n          </div>\r\n          <div class=\"row\">\r\n             <div class=\"col-md-4 \">\r\n                <div style=\"    margin-left: -14px;  font-size: 11px;\"><b >{{p.variants}}</b></div>\r\n             </div>\r\n             <div class=\"col-md-8\">\r\n                <div><nz-tag [nzColor]=\"'#f50a0a'\" style=\"margin-left: 20px;\"> &#8360; {{p.price}}</nz-tag></div>\r\n              </div>\r\n            </div>\r\n           <!-- <div style=\"text-align:center; margin-left: 0px;\"><b>{{p.name | uppercase}}</b></div>\r\n          <div style=\"text-align:center; margin-left: 0px;\"><b>{{p.variants}}</b></div>\r\n           <div><nz-tag [nzColor]=\"'#f50a0a'\" style=\"margin-left: 20px;\"> &#8360; {{p.price}}</nz-tag></div>   -->\r\n\r\n      </nz-card>\r\n      <div >\r\n        <ng-template #coverTemplate>\r\n          <img #image  [src]=\"p.image\" height=\"120px\" width=\"80px\" />\r\n        </ng-template>\r\n      </div>\r\n      <br />\r\n    </div>\r\n  </div>\r\n</nz-card>";
    /***/
  },

  /***/
  "./node_modules/raw-loader/dist/cjs.js!./src/app/recent-transactions/recent-transactions.component.html":
  /*!**************************************************************************************************************!*\
    !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/recent-transactions/recent-transactions.component.html ***!
    \**************************************************************************************************************/

  /*! exports provided: default */

  /***/
  function node_modulesRawLoaderDistCjsJsSrcAppRecentTransactionsRecentTransactionsComponentHtml(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony default export */


    __webpack_exports__["default"] = "<nz-table *ngIf=\"checking()\" [nzData]=\"data\"  #headerTable  [nzPageSize]=\"50\" [nzScroll]=\"{ y: '240px' }\">\r\n    <thead>\r\n      <tr>\r\n        <th nzWidth=\"160px\">Name</th>\r\n        <th nzWidth=\"160px\">Date</th>\r\n        <th nzWidth=\"160px\" >Amount</th>\r\n        <th >Products</th>\r\n      </tr>\r\n    </thead>\r\n    <tbody>\r\n      <tr  *ngFor=\"let d of data\">\r\n        <td>{{ d.createdBy }}</td>\r\n        <td>{{ d.date }}</td>\r\n        <td>{{ d.amount }}</td>\r\n     <!-- <td><a (click)=\"showproducts(d.productTransactions)\">Show</a></td> -->\r\n   <td >  <button nz-tooltip nzTooltipTitle=\"Click to view products\" (click)=\"showproducts(d.productTransactions)\"  nzGhost=\"true\" style=\"color:#0062cc;border-color:#0062cc\" nzSize=\"small\" nz-button nzType=\"primary\"><i nz-icon nzType=\"eye\"></i>show</button> </td>\r\n      </tr>\r\n    </tbody>\r\n  </nz-table>\r\n  <nz-modal [(nzVisible)]=\"isVisible\" nzTitle=\"Products\" (nzOnCancel)=\"handleCancel()\" (nzOnOk)=\"handleOk()\">\r\n      <!-- <nz-card nzHoverable style=\"width:100px\" [nzCover]=\"coverTemplate\">\r\n        <nz-card-meta style=\"font-size:100px\" nzTitle=\"\" nzDescription=\"\"></nz-card-meta>\r\n      </nz-card>\r\n      <ng-template #coverTemplate>\r\n        <img alt=\"example\" [src]=productimage />\r\n        <h2 style=\"text-align:center;font-family:Arial, Helvetica, sans-serif;text-decoration:none\">{{showproductName}} </h2>\r\n        \r\n        <h3 style=\"font-family:Arial, Helvetica, sans-serif;padding-left:5px;font-size:20px\">Qty:</h3>\r\n      </ng-template> -->\r\n      <div nz-row>\r\n      <div nz-col nzXs=\"24\" nzSm=\"24\" nzMd=\"5\" nzLg=\"7\" nzXl=\"7\" nzSpan=\"7\" nzOffset=\"1\" *ngFor=\"let p of productsarray\">\r\n      <nz-card   class=\"cardShadow\" style=\"background-color:black\" nzHoverable style=\"width:150px;margin-top:15px\">\r\n     <img [src]=p.product.image style=\"width:75px;height:75px\">\r\n        <hr>\r\n        <b style=\"font-size:12px;padding:0px\"> {{p.product.name | uppercase}}</b><br>\r\n        <b style=\"font-size:10px;padding:0px\" >{{p.product.variants}} </b><br>\r\n        <b style=\"font-size:12px;padding:0px\" >Quantity: {{p.quantity}} </b><br>\r\n        <!-- <b style=\"font-size:12px;padding:0px\" >Price: {{p.product.price}} </b> -->\r\n        <nz-tag style=\"margin-top:2px\" [nzColor]=\"'#f50a0a'\" > &#8360; {{p.product.price}}</nz-tag>\r\n\r\n     \r\n      \r\n      <!-- <div style=\"text-align:center; margin-left: 0px;\"><b>Product:{{p.product.name}}</b></div>\r\n      <div style=\"text-align:center; margin-left: 0px;\"><b>Quantity:{{p.quantity}}</b></div>\r\n       <div><nz-tag [nzColor]=\"'#f50a0a'\" style=\"margin-left: 20px;\"> &#8360; {{p.product.price}}</nz-tag></div>   -->\r\n\r\n     \r\n      </nz-card>\r\n      </div>\r\n      </div>\r\n    </nz-modal>";
    /***/
  },

  /***/
  "./node_modules/tslib/tslib.es6.js":
  /*!*****************************************!*\
    !*** ./node_modules/tslib/tslib.es6.js ***!
    \*****************************************/

  /*! exports provided: __extends, __assign, __rest, __decorate, __param, __metadata, __awaiter, __generator, __exportStar, __values, __read, __spread, __spreadArrays, __await, __asyncGenerator, __asyncDelegator, __asyncValues, __makeTemplateObject, __importStar, __importDefault */

  /***/
  function node_modulesTslibTslibEs6Js(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "__extends", function () {
      return __extends;
    });
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "__assign", function () {
      return _assign;
    });
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "__rest", function () {
      return __rest;
    });
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "__decorate", function () {
      return __decorate;
    });
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "__param", function () {
      return __param;
    });
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "__metadata", function () {
      return __metadata;
    });
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "__awaiter", function () {
      return __awaiter;
    });
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "__generator", function () {
      return __generator;
    });
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "__exportStar", function () {
      return __exportStar;
    });
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "__values", function () {
      return __values;
    });
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "__read", function () {
      return __read;
    });
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "__spread", function () {
      return __spread;
    });
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "__spreadArrays", function () {
      return __spreadArrays;
    });
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "__await", function () {
      return __await;
    });
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "__asyncGenerator", function () {
      return __asyncGenerator;
    });
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "__asyncDelegator", function () {
      return __asyncDelegator;
    });
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "__asyncValues", function () {
      return __asyncValues;
    });
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "__makeTemplateObject", function () {
      return __makeTemplateObject;
    });
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "__importStar", function () {
      return __importStar;
    });
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "__importDefault", function () {
      return __importDefault;
    });
    /*! *****************************************************************************
    Copyright (c) Microsoft Corporation. All rights reserved.
    Licensed under the Apache License, Version 2.0 (the "License"); you may not use
    this file except in compliance with the License. You may obtain a copy of the
    License at http://www.apache.org/licenses/LICENSE-2.0
    
    THIS CODE IS PROVIDED ON AN *AS IS* BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, EITHER EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION ANY IMPLIED
    WARRANTIES OR CONDITIONS OF TITLE, FITNESS FOR A PARTICULAR PURPOSE,
    MERCHANTABLITY OR NON-INFRINGEMENT.
    
    See the Apache Version 2.0 License for specific language governing permissions
    and limitations under the License.
    ***************************************************************************** */

    /* global Reflect, Promise */


    var _extendStatics = function extendStatics(d, b) {
      _extendStatics = Object.setPrototypeOf || {
        __proto__: []
      } instanceof Array && function (d, b) {
        d.__proto__ = b;
      } || function (d, b) {
        for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
      };

      return _extendStatics(d, b);
    };

    function __extends(d, b) {
      _extendStatics(d, b);

      function __() {
        this.constructor = d;
      }

      d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    }

    var _assign = function __assign() {
      _assign = Object.assign || function __assign(t) {
        for (var s, i = 1, n = arguments.length; i < n; i++) {
          s = arguments[i];

          for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p)) t[p] = s[p];
        }

        return t;
      };

      return _assign.apply(this, arguments);
    };

    function __rest(s, e) {
      var t = {};

      for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p) && e.indexOf(p) < 0) t[p] = s[p];

      if (s != null && typeof Object.getOwnPropertySymbols === "function") for (var i = 0, p = Object.getOwnPropertySymbols(s); i < p.length; i++) {
        if (e.indexOf(p[i]) < 0 && Object.prototype.propertyIsEnumerable.call(s, p[i])) t[p[i]] = s[p[i]];
      }
      return t;
    }

    function __decorate(decorators, target, key, desc) {
      var c = arguments.length,
          r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc,
          d;
      if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
      return c > 3 && r && Object.defineProperty(target, key, r), r;
    }

    function __param(paramIndex, decorator) {
      return function (target, key) {
        decorator(target, key, paramIndex);
      };
    }

    function __metadata(metadataKey, metadataValue) {
      if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(metadataKey, metadataValue);
    }

    function __awaiter(thisArg, _arguments, P, generator) {
      return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) {
          try {
            step(generator.next(value));
          } catch (e) {
            reject(e);
          }
        }

        function rejected(value) {
          try {
            step(generator["throw"](value));
          } catch (e) {
            reject(e);
          }
        }

        function step(result) {
          result.done ? resolve(result.value) : new P(function (resolve) {
            resolve(result.value);
          }).then(fulfilled, rejected);
        }

        step((generator = generator.apply(thisArg, _arguments || [])).next());
      });
    }

    function __generator(thisArg, body) {
      var _ = {
        label: 0,
        sent: function sent() {
          if (t[0] & 1) throw t[1];
          return t[1];
        },
        trys: [],
        ops: []
      },
          f,
          y,
          t,
          g;
      return g = {
        next: verb(0),
        "throw": verb(1),
        "return": verb(2)
      }, typeof Symbol === "function" && (g[Symbol.iterator] = function () {
        return this;
      }), g;

      function verb(n) {
        return function (v) {
          return step([n, v]);
        };
      }

      function step(op) {
        if (f) throw new TypeError("Generator is already executing.");

        while (_) try {
          if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
          if (y = 0, t) op = [op[0] & 2, t.value];

          switch (op[0]) {
            case 0:
            case 1:
              t = op;
              break;

            case 4:
              _.label++;
              return {
                value: op[1],
                done: false
              };

            case 5:
              _.label++;
              y = op[1];
              op = [0];
              continue;

            case 7:
              op = _.ops.pop();

              _.trys.pop();

              continue;

            default:
              if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) {
                _ = 0;
                continue;
              }

              if (op[0] === 3 && (!t || op[1] > t[0] && op[1] < t[3])) {
                _.label = op[1];
                break;
              }

              if (op[0] === 6 && _.label < t[1]) {
                _.label = t[1];
                t = op;
                break;
              }

              if (t && _.label < t[2]) {
                _.label = t[2];

                _.ops.push(op);

                break;
              }

              if (t[2]) _.ops.pop();

              _.trys.pop();

              continue;
          }

          op = body.call(thisArg, _);
        } catch (e) {
          op = [6, e];
          y = 0;
        } finally {
          f = t = 0;
        }

        if (op[0] & 5) throw op[1];
        return {
          value: op[0] ? op[1] : void 0,
          done: true
        };
      }
    }

    function __exportStar(m, exports) {
      for (var p in m) if (!exports.hasOwnProperty(p)) exports[p] = m[p];
    }

    function __values(o) {
      var m = typeof Symbol === "function" && o[Symbol.iterator],
          i = 0;
      if (m) return m.call(o);
      return {
        next: function next() {
          if (o && i >= o.length) o = void 0;
          return {
            value: o && o[i++],
            done: !o
          };
        }
      };
    }

    function __read(o, n) {
      var m = typeof Symbol === "function" && o[Symbol.iterator];
      if (!m) return o;
      var i = m.call(o),
          r,
          ar = [],
          e;

      try {
        while ((n === void 0 || n-- > 0) && !(r = i.next()).done) ar.push(r.value);
      } catch (error) {
        e = {
          error: error
        };
      } finally {
        try {
          if (r && !r.done && (m = i["return"])) m.call(i);
        } finally {
          if (e) throw e.error;
        }
      }

      return ar;
    }

    function __spread() {
      for (var ar = [], i = 0; i < arguments.length; i++) ar = ar.concat(__read(arguments[i]));

      return ar;
    }

    function __spreadArrays() {
      for (var s = 0, i = 0, il = arguments.length; i < il; i++) s += arguments[i].length;

      for (var r = Array(s), k = 0, i = 0; i < il; i++) for (var a = arguments[i], j = 0, jl = a.length; j < jl; j++, k++) r[k] = a[j];

      return r;
    }

    ;

    function __await(v) {
      return this instanceof __await ? (this.v = v, this) : new __await(v);
    }

    function __asyncGenerator(thisArg, _arguments, generator) {
      if (!Symbol.asyncIterator) throw new TypeError("Symbol.asyncIterator is not defined.");
      var g = generator.apply(thisArg, _arguments || []),
          i,
          q = [];
      return i = {}, verb("next"), verb("throw"), verb("return"), i[Symbol.asyncIterator] = function () {
        return this;
      }, i;

      function verb(n) {
        if (g[n]) i[n] = function (v) {
          return new Promise(function (a, b) {
            q.push([n, v, a, b]) > 1 || resume(n, v);
          });
        };
      }

      function resume(n, v) {
        try {
          step(g[n](v));
        } catch (e) {
          settle(q[0][3], e);
        }
      }

      function step(r) {
        r.value instanceof __await ? Promise.resolve(r.value.v).then(fulfill, reject) : settle(q[0][2], r);
      }

      function fulfill(value) {
        resume("next", value);
      }

      function reject(value) {
        resume("throw", value);
      }

      function settle(f, v) {
        if (f(v), q.shift(), q.length) resume(q[0][0], q[0][1]);
      }
    }

    function __asyncDelegator(o) {
      var i, p;
      return i = {}, verb("next"), verb("throw", function (e) {
        throw e;
      }), verb("return"), i[Symbol.iterator] = function () {
        return this;
      }, i;

      function verb(n, f) {
        i[n] = o[n] ? function (v) {
          return (p = !p) ? {
            value: __await(o[n](v)),
            done: n === "return"
          } : f ? f(v) : v;
        } : f;
      }
    }

    function __asyncValues(o) {
      if (!Symbol.asyncIterator) throw new TypeError("Symbol.asyncIterator is not defined.");
      var m = o[Symbol.asyncIterator],
          i;
      return m ? m.call(o) : (o = typeof __values === "function" ? __values(o) : o[Symbol.iterator](), i = {}, verb("next"), verb("throw"), verb("return"), i[Symbol.asyncIterator] = function () {
        return this;
      }, i);

      function verb(n) {
        i[n] = o[n] && function (v) {
          return new Promise(function (resolve, reject) {
            v = o[n](v), settle(resolve, reject, v.done, v.value);
          });
        };
      }

      function settle(resolve, reject, d, v) {
        Promise.resolve(v).then(function (v) {
          resolve({
            value: v,
            done: d
          });
        }, reject);
      }
    }

    function __makeTemplateObject(cooked, raw) {
      if (Object.defineProperty) {
        Object.defineProperty(cooked, "raw", {
          value: raw
        });
      } else {
        cooked.raw = raw;
      }

      return cooked;
    }

    ;

    function __importStar(mod) {
      if (mod && mod.__esModule) return mod;
      var result = {};
      if (mod != null) for (var k in mod) if (Object.hasOwnProperty.call(mod, k)) result[k] = mod[k];
      result.default = mod;
      return result;
    }

    function __importDefault(mod) {
      return mod && mod.__esModule ? mod : {
        default: mod
      };
    }
    /***/

  },

  /***/
  "./src/app/app-routing.module.ts":
  /*!***************************************!*\
    !*** ./src/app/app-routing.module.ts ***!
    \***************************************/

  /*! exports provided: AppRoutingModule, routingComponents */

  /***/
  function srcAppAppRoutingModuleTs(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function () {
      return AppRoutingModule;
    });
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "routingComponents", function () {
      return routingComponents;
    });
    /* harmony import */


    var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
    /*! tslib */
    "./node_modules/tslib/tslib.es6.js");
    /* harmony import */


    var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
    /*! @angular/core */
    "./node_modules/@angular/core/fesm2015/core.js");
    /* harmony import */


    var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
    /*! @angular/router */
    "./node_modules/@angular/router/fesm2015/router.js");
    /* harmony import */


    var _main_screen_main_screen_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
    /*! ./main-screen/main-screen.component */
    "./src/app/main-screen/main-screen.component.ts");
    /* harmony import */


    var _login_page_login_page_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
    /*! ./login-page/login-page.component */
    "./src/app/login-page/login-page.component.ts");
    /* harmony import */


    var _auth_guard__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
    /*! ./auth.guard */
    "./src/app/auth.guard.ts");

    const routes = [{
      path: '',
      component: _login_page_login_page_component__WEBPACK_IMPORTED_MODULE_4__["LoginPageComponent"]
    }, {
      path: 'login',
      component: _login_page_login_page_component__WEBPACK_IMPORTED_MODULE_4__["LoginPageComponent"]
    }, {
      path: 'main',
      component: _main_screen_main_screen_component__WEBPACK_IMPORTED_MODULE_3__["MainScreenComponent"],
      canActivate: [_auth_guard__WEBPACK_IMPORTED_MODULE_5__["AuthGuard"]]
    }, {
      path: 'categories/:category',
      component: _main_screen_main_screen_component__WEBPACK_IMPORTED_MODULE_3__["MainScreenComponent"],
      canActivate: [_auth_guard__WEBPACK_IMPORTED_MODULE_5__["AuthGuard"]]
    }, {
      path: 'admin',
      loadChildren: './admins/admins.module#AdminsModule'
    }];
    let AppRoutingModule = class AppRoutingModule {};
    AppRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
      imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forRoot(routes, {
        useHash: true
      })],
      exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]]
    })], AppRoutingModule);
    const routingComponents = [];
    /***/
  },

  /***/
  "./src/app/app.component.css":
  /*!***********************************!*\
    !*** ./src/app/app.component.css ***!
    \***********************************/

  /*! exports provided: default */

  /***/
  function srcAppAppComponentCss(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony default export */


    __webpack_exports__["default"] = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2FwcC5jb21wb25lbnQuY3NzIn0= */";
    /***/
  },

  /***/
  "./src/app/app.component.ts":
  /*!**********************************!*\
    !*** ./src/app/app.component.ts ***!
    \**********************************/

  /*! exports provided: AppComponent */

  /***/
  function srcAppAppComponentTs(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "AppComponent", function () {
      return AppComponent;
    });
    /* harmony import */


    var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
    /*! tslib */
    "./node_modules/tslib/tslib.es6.js");
    /* harmony import */


    var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
    /*! @angular/core */
    "./node_modules/@angular/core/fesm2015/core.js");
    /* harmony import */


    var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
    /*! @angular/router */
    "./node_modules/@angular/router/fesm2015/router.js");

    let AppComponent = class AppComponent {
      constructor(router) {
        this.router = router;
        this.title = 'AntDesign';
      }

      ngOnInit() {}

    };

    AppComponent.ctorParameters = () => [{
      type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]
    }];

    AppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
      selector: 'app-root',
      template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(
      /*! raw-loader!./app.component.html */
      "./node_modules/raw-loader/dist/cjs.js!./src/app/app.component.html")).default,
      styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(
      /*! ./app.component.css */
      "./src/app/app.component.css")).default]
    })], AppComponent);
    /***/
  },

  /***/
  "./src/app/app.module.ts":
  /*!*******************************!*\
    !*** ./src/app/app.module.ts ***!
    \*******************************/

  /*! exports provided: AppModule */

  /***/
  function srcAppAppModuleTs(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "AppModule", function () {
      return AppModule;
    });
    /* harmony import */


    var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
    /*! tslib */
    "./node_modules/tslib/tslib.es6.js");
    /* harmony import */


    var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
    /*! @angular/platform-browser */
    "./node_modules/@angular/platform-browser/fesm2015/platform-browser.js");
    /* harmony import */


    var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
    /*! @angular/core */
    "./node_modules/@angular/core/fesm2015/core.js");
    /* harmony import */


    var _app_routing_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
    /*! ./app-routing.module */
    "./src/app/app-routing.module.ts");
    /* harmony import */


    var _app_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
    /*! ./app.component */
    "./src/app/app.component.ts");
    /* harmony import */


    var ng_zorro_antd__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
    /*! ng-zorro-antd */
    "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd.js");
    /* harmony import */


    var _angular_forms__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(
    /*! @angular/forms */
    "./node_modules/@angular/forms/fesm2015/forms.js");
    /* harmony import */


    var _angular_common_http__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(
    /*! @angular/common/http */
    "./node_modules/@angular/common/fesm2015/http.js");
    /* harmony import */


    var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(
    /*! @angular/platform-browser/animations */
    "./node_modules/@angular/platform-browser/fesm2015/animations.js");
    /* harmony import */


    var _angular_common__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(
    /*! @angular/common */
    "./node_modules/@angular/common/fesm2015/common.js");
    /* harmony import */


    var _angular_common_locales_en__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(
    /*! @angular/common/locales/en */
    "./node_modules/@angular/common/locales/en.js");
    /* harmony import */


    var _angular_common_locales_en__WEBPACK_IMPORTED_MODULE_10___default = /*#__PURE__*/__webpack_require__.n(_angular_common_locales_en__WEBPACK_IMPORTED_MODULE_10__);
    /* harmony import */


    var ng_zorro_antd_button__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(
    /*! ng-zorro-antd/button */
    "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd-button.js");
    /* harmony import */


    var ng_zorro_antd_icon__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(
    /*! ng-zorro-antd/icon */
    "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd-icon.js");
    /* harmony import */


    var ng_zorro_antd_card__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(
    /*! ng-zorro-antd/card */
    "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd-card.js");
    /* harmony import */


    var ng_zorro_antd_layout__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(
    /*! ng-zorro-antd/layout */
    "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd-layout.js");
    /* harmony import */


    var _main_screen_main_screen_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(
    /*! ./main-screen/main-screen.component */
    "./src/app/main-screen/main-screen.component.ts");
    /* harmony import */


    var _product_listing_product_listing_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(
    /*! ./product-listing/product-listing.component */
    "./src/app/product-listing/product-listing.component.ts");
    /* harmony import */


    var _checkout_checkout_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(
    /*! ./checkout/checkout.component */
    "./src/app/checkout/checkout.component.ts");
    /* harmony import */


    var ng_zorro_antd_grid__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(
    /*! ng-zorro-antd/grid */
    "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd-grid.js");
    /* harmony import */


    var ng_zorro_antd_popover__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(
    /*! ng-zorro-antd/popover */
    "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd-popover.js");
    /* harmony import */


    var ng_zorro_antd_modal__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(
    /*! ng-zorro-antd/modal */
    "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd-modal.js");
    /* harmony import */


    var _login_page_login_page_component__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(
    /*! ./login-page/login-page.component */
    "./src/app/login-page/login-page.component.ts");
    /* harmony import */


    var ng_zorro_antd_message__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(
    /*! ng-zorro-antd/message */
    "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd-message.js");
    /* harmony import */


    var ng_zorro_antd_date_picker__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(
    /*! ng-zorro-antd/date-picker */
    "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd-date-picker.js");
    /* harmony import */


    var ng_zorro_antd_menu__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(
    /*! ng-zorro-antd/menu */
    "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd-menu.js");
    /* harmony import */


    var ng_chartist__WEBPACK_IMPORTED_MODULE_25__ = __webpack_require__(
    /*! ng-chartist */
    "./node_modules/ng-chartist/fesm2015/ng-chartist.js");
    /* harmony import */


    var _recent_transactions_recent_transactions_component__WEBPACK_IMPORTED_MODULE_26__ = __webpack_require__(
    /*! ./recent-transactions/recent-transactions.component */
    "./src/app/recent-transactions/recent-transactions.component.ts");
    /* harmony import */


    var ng_zorro_antd_badge__WEBPACK_IMPORTED_MODULE_27__ = __webpack_require__(
    /*! ng-zorro-antd/badge */
    "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd-badge.js");
    /* harmony import */


    var ng_zorro_antd_auto_complete__WEBPACK_IMPORTED_MODULE_28__ = __webpack_require__(
    /*! ng-zorro-antd/auto-complete */
    "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd-auto-complete.js");
    /* harmony import */


    var ng_zorro_antd_tag__WEBPACK_IMPORTED_MODULE_29__ = __webpack_require__(
    /*! ng-zorro-antd/tag */
    "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd-tag.js");
    /* harmony import */


    var ng_zorro_antd_popconfirm__WEBPACK_IMPORTED_MODULE_30__ = __webpack_require__(
    /*! ng-zorro-antd/popconfirm */
    "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd-popconfirm.js");
    /* harmony import */


    var ng_zorro_antd_divider__WEBPACK_IMPORTED_MODULE_31__ = __webpack_require__(
    /*! ng-zorro-antd/divider */
    "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd-divider.js");
    /* harmony import */


    var ng_zorro_antd_spin__WEBPACK_IMPORTED_MODULE_32__ = __webpack_require__(
    /*! ng-zorro-antd/spin */
    "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd-spin.js");
    /* harmony import */


    var _auth_guard__WEBPACK_IMPORTED_MODULE_33__ = __webpack_require__(
    /*! ./auth.guard */
    "./src/app/auth.guard.ts");
    /* harmony import */


    var ng_zorro_antd_avatar__WEBPACK_IMPORTED_MODULE_34__ = __webpack_require__(
    /*! ng-zorro-antd/avatar */
    "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd-avatar.js");
    /* harmony import */


    var _request_intercepts__WEBPACK_IMPORTED_MODULE_35__ = __webpack_require__(
    /*! ./request.intercepts */
    "./src/app/request.intercepts.ts");

    ;
    Object(_angular_common__WEBPACK_IMPORTED_MODULE_9__["registerLocaleData"])(_angular_common_locales_en__WEBPACK_IMPORTED_MODULE_10___default.a);
    let AppModule = class AppModule {};
    AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
      declarations: [_app_component__WEBPACK_IMPORTED_MODULE_4__["AppComponent"], _main_screen_main_screen_component__WEBPACK_IMPORTED_MODULE_15__["MainScreenComponent"], _product_listing_product_listing_component__WEBPACK_IMPORTED_MODULE_16__["ProductListingComponent"], _checkout_checkout_component__WEBPACK_IMPORTED_MODULE_17__["CheckoutComponent"], _login_page_login_page_component__WEBPACK_IMPORTED_MODULE_21__["LoginPageComponent"], _recent_transactions_recent_transactions_component__WEBPACK_IMPORTED_MODULE_26__["RecentTransactionsComponent"]],
      imports: [_angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"], _app_routing_module__WEBPACK_IMPORTED_MODULE_3__["AppRoutingModule"], ng_zorro_antd__WEBPACK_IMPORTED_MODULE_5__["NgZorroAntdModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_6__["FormsModule"], _angular_common_http__WEBPACK_IMPORTED_MODULE_7__["HttpClientModule"], _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_8__["BrowserAnimationsModule"], ng_zorro_antd_button__WEBPACK_IMPORTED_MODULE_11__["NzButtonModule"], ng_zorro_antd_tag__WEBPACK_IMPORTED_MODULE_29__["NzTagModule"], ng_zorro_antd_icon__WEBPACK_IMPORTED_MODULE_12__["NzIconModule"], ng_zorro_antd_spin__WEBPACK_IMPORTED_MODULE_32__["NzSpinModule"], ng_zorro_antd_card__WEBPACK_IMPORTED_MODULE_13__["NzCardModule"], ng_zorro_antd_layout__WEBPACK_IMPORTED_MODULE_14__["NzLayoutModule"], ng_zorro_antd_grid__WEBPACK_IMPORTED_MODULE_18__["NzGridModule"], ng_zorro_antd_popover__WEBPACK_IMPORTED_MODULE_19__["NzPopoverModule"], ng_zorro_antd_popconfirm__WEBPACK_IMPORTED_MODULE_30__["NzPopconfirmModule"], ng_zorro_antd_modal__WEBPACK_IMPORTED_MODULE_20__["NzModalModule"], ng_zorro_antd_message__WEBPACK_IMPORTED_MODULE_22__["NzMessageModule"], ng_zorro_antd_message__WEBPACK_IMPORTED_MODULE_22__["NzMessageModule"], ng_zorro_antd_date_picker__WEBPACK_IMPORTED_MODULE_23__["NzDatePickerModule"], ng_zorro_antd_menu__WEBPACK_IMPORTED_MODULE_24__["NzMenuModule"], _angular_forms__WEBPACK_IMPORTED_MODULE_6__["ReactiveFormsModule"], ng_chartist__WEBPACK_IMPORTED_MODULE_25__["ChartistModule"], ng_zorro_antd_auto_complete__WEBPACK_IMPORTED_MODULE_28__["NzAutocompleteModule"], ng_zorro_antd_badge__WEBPACK_IMPORTED_MODULE_27__["NzBadgeModule"], ng_zorro_antd_divider__WEBPACK_IMPORTED_MODULE_31__["NzDividerModule"], ng_zorro_antd_avatar__WEBPACK_IMPORTED_MODULE_34__["NzAvatarModule"]],
      providers: [{
        provide: ng_zorro_antd__WEBPACK_IMPORTED_MODULE_5__["NZ_I18N"],
        useValue: ng_zorro_antd__WEBPACK_IMPORTED_MODULE_5__["en_US"]
      }, _auth_guard__WEBPACK_IMPORTED_MODULE_33__["AuthGuard"], {
        provide: _angular_common_http__WEBPACK_IMPORTED_MODULE_7__["HTTP_INTERCEPTORS"],
        useClass: _request_intercepts__WEBPACK_IMPORTED_MODULE_35__["NoopInterceptor"],
        multi: true
      }],
      bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_4__["AppComponent"]]
    })], AppModule);
    /***/
  },

  /***/
  "./src/app/auth.guard.ts":
  /*!*******************************!*\
    !*** ./src/app/auth.guard.ts ***!
    \*******************************/

  /*! exports provided: AuthGuard */

  /***/
  function srcAppAuthGuardTs(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "AuthGuard", function () {
      return AuthGuard;
    });
    /* harmony import */


    var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
    /*! tslib */
    "./node_modules/tslib/tslib.es6.js");
    /* harmony import */


    var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
    /*! @angular/core */
    "./node_modules/@angular/core/fesm2015/core.js");
    /* harmony import */


    var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
    /*! @angular/router */
    "./node_modules/@angular/router/fesm2015/router.js");
    /* harmony import */


    var _main_screen_mainscreen_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
    /*! ./main-screen/mainscreen.service */
    "./src/app/main-screen/mainscreen.service.ts");

    let AuthGuard = class AuthGuard {
      constructor(service, route) {
        this.service = service;
        this.route = route;
      }

      canActivate() {
        if (this.service.loggedIn() && this.service.userRole()) {
          return true;
        } else {
          this.route.navigate(['login']);
          return false;
        }
      }

      canLoad() {
        if (this.service.loggedIn() && this.service.adminRole()) {
          return true;
        } else {
          this.route.navigate(['login']);
          return false;
        }
      }

    };

    AuthGuard.ctorParameters = () => [{
      type: _main_screen_mainscreen_service__WEBPACK_IMPORTED_MODULE_3__["MainscreenService"]
    }, {
      type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]
    }];

    AuthGuard = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
      providedIn: 'root'
    })], AuthGuard);
    /***/
  },

  /***/
  "./src/app/checkout/Checkout.ts":
  /*!**************************************!*\
    !*** ./src/app/checkout/Checkout.ts ***!
    \**************************************/

  /*! exports provided: Checkout */

  /***/
  function srcAppCheckoutCheckoutTs(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "Checkout", function () {
      return Checkout;
    });
    /* harmony import */


    var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
    /*! tslib */
    "./node_modules/tslib/tslib.es6.js");

    class Checkout {}
    /***/

  },

  /***/
  "./src/app/checkout/checkout.component.css":
  /*!*************************************************!*\
    !*** ./src/app/checkout/checkout.component.css ***!
    \*************************************************/

  /*! exports provided: default */

  /***/
  function srcAppCheckoutCheckoutComponentCss(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony default export */


    __webpack_exports__["default"] = ".global-search-item {\r\n    display: -webkit-box;\r\n    display: flex;\r\n  }\r\n\r\n  .global-search-item-desc {\r\n    -webkit-box-flex: 1;\r\n            flex: auto;\r\n    text-overflow: ellipsis;\r\n    overflow: hidden;\r\n  }\r\n\r\n  .global-search-item-count {\r\n    -webkit-box-flex: 0;\r\n            flex: none;\r\n  }\r\n\r\n  #cardShadow{\r\n    /* border: 1px solid; */\r\n    box-shadow: 5px 10px 18px #888888;\r\n    \r\n  }\r\n\r\n  .main-box.no-header {\r\n    padding-top: 20px;\r\n}\r\n\r\n  .main-box {\r\n    background: #FFFFFF;\r\n    -o-box-shadow: 1px 1px 2px 0 #CCCCCC;\r\n    -ms-box-shadow: 1px 1px 2px 0 #CCCCCC;\r\n    box-shadow: 1px 1px 2px 0 #CCCCCC;\r\n    margin-bottom: 16px;\r\n    -webikt-border-radius: 3px;\r\n    border-radius: 3px;\r\n}\r\n\r\n  .table a.table-link.danger {\r\n    color: #e74c3c;\r\n}\r\n\r\n  .label {\r\n    border-radius: 3px;\r\n    font-size: 0.875em;\r\n    font-weight: 600;\r\n}\r\n\r\n  .user-list tbody td .user-subhead {\r\n    font-size: 0.875em;\r\n    font-style: italic;\r\n}\r\n\r\n  .user-list tbody td .user-link {\r\n    display: block;\r\n    font-size: 1.25em;\r\n    padding-top: 3px;\r\n    margin-left: 60px;\r\n}\r\n\r\n  a {\r\n    color: #3498db;\r\n    outline: none!important;\r\n}\r\n\r\n  .user-list tbody td>img {\r\n    position: relative;\r\n    max-width: 50px;\r\n    float: left;\r\n    margin-right: 15px;\r\n}\r\n\r\n  .table thead tr th {\r\n    text-transform: uppercase;\r\n    font-size: 0.875em;\r\n}\r\n\r\n  .table thead tr th {\r\n    border-bottom: 2px solid #e7ebee;\r\n}\r\n\r\n  .table tbody tr td:first-child {\r\n    font-size: 1.125em;\r\n    font-weight: 300;\r\n}\r\n\r\n  .table tbody tr td {\r\n    font-size: 0.875em;\r\n    vertical-align: middle;\r\n    border-top: 1px solid #e7ebee;\r\n    padding: 12px 8px;\r\n}\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY2hlY2tvdXQvY2hlY2tvdXQuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtJQUNJLG9CQUFhO0lBQWIsYUFBYTtFQUNmOztFQUVBO0lBQ0UsbUJBQVU7WUFBVixVQUFVO0lBQ1YsdUJBQXVCO0lBQ3ZCLGdCQUFnQjtFQUNsQjs7RUFFQTtJQUNFLG1CQUFVO1lBQVYsVUFBVTtFQUNaOztFQUNBO0lBQ0UsdUJBQXVCO0lBQ3ZCLGlDQUFpQzs7RUFFbkM7O0VBR0Y7SUFDSSxpQkFBaUI7QUFDckI7O0VBQ0E7SUFDSSxtQkFBbUI7SUFHbkIsb0NBQW9DO0lBQ3BDLHFDQUFxQztJQUNyQyxpQ0FBaUM7SUFDakMsbUJBQW1CO0lBQ25CLDBCQUEwQjtJQUUxQixrQkFBa0I7QUFDdEI7O0VBQ0E7SUFDSSxjQUFjO0FBQ2xCOztFQUNBO0lBQ0ksa0JBQWtCO0lBQ2xCLGtCQUFrQjtJQUNsQixnQkFBZ0I7QUFDcEI7O0VBQ0E7SUFDSSxrQkFBa0I7SUFDbEIsa0JBQWtCO0FBQ3RCOztFQUNBO0lBQ0ksY0FBYztJQUNkLGlCQUFpQjtJQUNqQixnQkFBZ0I7SUFDaEIsaUJBQWlCO0FBQ3JCOztFQUNBO0lBQ0ksY0FBYztJQUNkLHVCQUF1QjtBQUMzQjs7RUFDQTtJQUNJLGtCQUFrQjtJQUNsQixlQUFlO0lBQ2YsV0FBVztJQUNYLGtCQUFrQjtBQUN0Qjs7RUFFQTtJQUNJLHlCQUF5QjtJQUN6QixrQkFBa0I7QUFDdEI7O0VBQ0E7SUFDSSxnQ0FBZ0M7QUFDcEM7O0VBQ0E7SUFDSSxrQkFBa0I7SUFDbEIsZ0JBQWdCO0FBQ3BCOztFQUNBO0lBQ0ksa0JBQWtCO0lBQ2xCLHNCQUFzQjtJQUN0Qiw2QkFBNkI7SUFDN0IsaUJBQWlCO0FBQ3JCIiwiZmlsZSI6InNyYy9hcHAvY2hlY2tvdXQvY2hlY2tvdXQuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5nbG9iYWwtc2VhcmNoLWl0ZW0ge1xyXG4gICAgZGlzcGxheTogZmxleDtcclxuICB9XHJcblxyXG4gIC5nbG9iYWwtc2VhcmNoLWl0ZW0tZGVzYyB7XHJcbiAgICBmbGV4OiBhdXRvO1xyXG4gICAgdGV4dC1vdmVyZmxvdzogZWxsaXBzaXM7XHJcbiAgICBvdmVyZmxvdzogaGlkZGVuO1xyXG4gIH1cclxuXHJcbiAgLmdsb2JhbC1zZWFyY2gtaXRlbS1jb3VudCB7XHJcbiAgICBmbGV4OiBub25lO1xyXG4gIH1cclxuICAjY2FyZFNoYWRvd3tcclxuICAgIC8qIGJvcmRlcjogMXB4IHNvbGlkOyAqL1xyXG4gICAgYm94LXNoYWRvdzogNXB4IDEwcHggMThweCAjODg4ODg4O1xyXG4gICAgXHJcbiAgfVxyXG5cclxuXHJcbi5tYWluLWJveC5uby1oZWFkZXIge1xyXG4gICAgcGFkZGluZy10b3A6IDIwcHg7XHJcbn1cclxuLm1haW4tYm94IHtcclxuICAgIGJhY2tncm91bmQ6ICNGRkZGRkY7XHJcbiAgICAtd2Via2l0LWJveC1zaGFkb3c6IDFweCAxcHggMnB4IDAgI0NDQ0NDQztcclxuICAgIC1tb3otYm94LXNoYWRvdzogMXB4IDFweCAycHggMCAjQ0NDQ0NDO1xyXG4gICAgLW8tYm94LXNoYWRvdzogMXB4IDFweCAycHggMCAjQ0NDQ0NDO1xyXG4gICAgLW1zLWJveC1zaGFkb3c6IDFweCAxcHggMnB4IDAgI0NDQ0NDQztcclxuICAgIGJveC1zaGFkb3c6IDFweCAxcHggMnB4IDAgI0NDQ0NDQztcclxuICAgIG1hcmdpbi1ib3R0b206IDE2cHg7XHJcbiAgICAtd2ViaWt0LWJvcmRlci1yYWRpdXM6IDNweDtcclxuICAgIC1tb3otYm9yZGVyLXJhZGl1czogM3B4O1xyXG4gICAgYm9yZGVyLXJhZGl1czogM3B4O1xyXG59XHJcbi50YWJsZSBhLnRhYmxlLWxpbmsuZGFuZ2VyIHtcclxuICAgIGNvbG9yOiAjZTc0YzNjO1xyXG59XHJcbi5sYWJlbCB7XHJcbiAgICBib3JkZXItcmFkaXVzOiAzcHg7XHJcbiAgICBmb250LXNpemU6IDAuODc1ZW07XHJcbiAgICBmb250LXdlaWdodDogNjAwO1xyXG59XHJcbi51c2VyLWxpc3QgdGJvZHkgdGQgLnVzZXItc3ViaGVhZCB7XHJcbiAgICBmb250LXNpemU6IDAuODc1ZW07XHJcbiAgICBmb250LXN0eWxlOiBpdGFsaWM7XHJcbn1cclxuLnVzZXItbGlzdCB0Ym9keSB0ZCAudXNlci1saW5rIHtcclxuICAgIGRpc3BsYXk6IGJsb2NrO1xyXG4gICAgZm9udC1zaXplOiAxLjI1ZW07XHJcbiAgICBwYWRkaW5nLXRvcDogM3B4O1xyXG4gICAgbWFyZ2luLWxlZnQ6IDYwcHg7XHJcbn1cclxuYSB7XHJcbiAgICBjb2xvcjogIzM0OThkYjtcclxuICAgIG91dGxpbmU6IG5vbmUhaW1wb3J0YW50O1xyXG59XHJcbi51c2VyLWxpc3QgdGJvZHkgdGQ+aW1nIHtcclxuICAgIHBvc2l0aW9uOiByZWxhdGl2ZTtcclxuICAgIG1heC13aWR0aDogNTBweDtcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG4gICAgbWFyZ2luLXJpZ2h0OiAxNXB4O1xyXG59XHJcblxyXG4udGFibGUgdGhlYWQgdHIgdGgge1xyXG4gICAgdGV4dC10cmFuc2Zvcm06IHVwcGVyY2FzZTtcclxuICAgIGZvbnQtc2l6ZTogMC44NzVlbTtcclxufVxyXG4udGFibGUgdGhlYWQgdHIgdGgge1xyXG4gICAgYm9yZGVyLWJvdHRvbTogMnB4IHNvbGlkICNlN2ViZWU7XHJcbn1cclxuLnRhYmxlIHRib2R5IHRyIHRkOmZpcnN0LWNoaWxkIHtcclxuICAgIGZvbnQtc2l6ZTogMS4xMjVlbTtcclxuICAgIGZvbnQtd2VpZ2h0OiAzMDA7XHJcbn1cclxuLnRhYmxlIHRib2R5IHRyIHRkIHtcclxuICAgIGZvbnQtc2l6ZTogMC44NzVlbTtcclxuICAgIHZlcnRpY2FsLWFsaWduOiBtaWRkbGU7XHJcbiAgICBib3JkZXItdG9wOiAxcHggc29saWQgI2U3ZWJlZTtcclxuICAgIHBhZGRpbmc6IDEycHggOHB4O1xyXG59Il19 */";
    /***/
  },

  /***/
  "./src/app/checkout/checkout.component.ts":
  /*!************************************************!*\
    !*** ./src/app/checkout/checkout.component.ts ***!
    \************************************************/

  /*! exports provided: CheckoutComponent */

  /***/
  function srcAppCheckoutCheckoutComponentTs(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "CheckoutComponent", function () {
      return CheckoutComponent;
    });
    /* harmony import */


    var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
    /*! tslib */
    "./node_modules/tslib/tslib.es6.js");
    /* harmony import */


    var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
    /*! @angular/core */
    "./node_modules/@angular/core/fesm2015/core.js");
    /* harmony import */


    var _main_screen_mainscreen_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
    /*! ../main-screen/mainscreen.service */
    "./src/app/main-screen/mainscreen.service.ts");
    /* harmony import */


    var _Checkout__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
    /*! ./Checkout */
    "./src/app/checkout/Checkout.ts");
    /* harmony import */


    var ng_zorro_antd_message__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
    /*! ng-zorro-antd/message */
    "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd-message.js");
    /* harmony import */


    var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
    /*! @angular/router */
    "./node_modules/@angular/router/fesm2015/router.js");

    let CheckoutComponent = class CheckoutComponent {
      constructor(interactionServ, message, router, activeRoute) {
        this.interactionServ = interactionServ;
        this.message = message;
        this.router = router;
        this.activeRoute = activeRoute;
        this.checkoutProductsArray = [];
        this.productQuantity = 0;
        this.total = 0;
        this.isVisible = false;
        this.addButtonDisbale = false; // minusButtonDisbale = false;

        this.isVisible2 = false;
        this.imageVisible = false;
        this.options = [];
        this.checkOutObj = new _Checkout__WEBPACK_IMPORTED_MODULE_3__["Checkout"]();
        this.checking = false;
        this.chekingSetting = false;
        this.objToPushForTransaction = [];
        this.checkingMinusCall = false; //////Second Modal

        this.user = [];
        this.buttonDisable = false;
        this.isVisible1 = false;
      }

      unloadHandler(event) {
        this.checkoutProductsArray.forEach(data => {
          let obj = {
            "quantity": 0,
            "count": data.productQuantity
          };
          this.interactionServ.updateMinusAllQuantity(data.id, obj).subscribe(d => {
            if (d) {
              data.productqty = d.result.qty;
              let index = this.checkoutProductsArray.findIndex(p => p.id == data.id);
              this.total = this.total - this.checkoutProductsArray[index].productPrice;
              this.checkoutProductsArray.splice(index, 1);
            }
          });
        });
      }

      ngOnInit() {
        this.interactionServ.getSetting().subscribe(d => {
          this.activeRoute.paramMap.subscribe(params => {
            this.userName = params['params'].user;
            console.log(this.userName);
          });

          if (d) {
            this.settingHeader = d[0];
            this.chekingSetting = true;
          } // if (!this.settingHeader) {
          //   this.settingHeader = {
          //     header: "",
          //     logo: '',
          //     footer: "",
          //     headerName: ""
          //   }
          // }
          // else if (this.settingHeader.headerName == undefined) {
          //   this.settingHeader.headerName = ""
          // }
          // else if (this.settingHeader.header == undefined) { this.settingHeader.header = "" }
          // else if (this.settingHeader.footer == undefined) { this.settingHeader.footer = "" }
          // else if (this.settingHeader.logo == undefined) { this.settingHeader.logo = "" }
          // else { this.imageVisible = true }

        });
        this.populateCols(); // <<<<<<< variants-work

        this.interactionServ.productMessage$.subscribe(d => {
          console.log("dsfsdgsdg", d);

          if (d) {
            let found = this.checkoutProductsArray.findIndex(p => p.productTitle == d["name"] && p.productVariant == d["variants"]);

            if (d['qty'] <= 0) {
              this.addButtonDisbale = true;
            }

            if (found > -1) {
              this.checkoutProductsArray[found].productPrice += d["price"]; // this.total = this.total + d["price"];

              this.checkoutProductsArray[found]["productQuantity"] += 1;
              this.checkoutProductsArray[found].productqty = d["qty"];
            } else {
              this.checkoutProductsArray.push({
                id: d["id"],
                productTitle: d["name"],
                productPrice: d["price"],
                productImage: d["image"],
                productQuantity: this.productQuantity = 1,
                productqty: d['qty'],
                printProductPrice: d["price"],
                productVariant: d["variants"]
              } // if (found > -1) {
              //   this.checkoutProductsArray[found].productPrice += d["price"];
              //   this.total = this.total + d["price"];
              //   this.checkoutProductsArray[found]["productQuantity"] += 1;
              //   this.checkoutProductsArray[found].productqty = d["qty"];
              // } else {
              //   this.checkoutProductsArray.push({
              //     id: d["id"],
              //     productTitle: d["name"],
              //     productPrice: d["price"],
              //     productImage: d["image"],
              //     productQuantity: this.productQuantity = 1,
              //     productqty: d['qty'],
              //     printProductPrice: d["price"]
              //   }
              //   );
              //   
              );
            }

            this.total += d["price"];
          }

          ;
        });
      }

      removeProductFromCheckout(data) {
        let obj1 = {
          "quantity": 0,
          "count": data.productQuantity
        };
        console.log("===========================", data);
        this.interactionServ.updateMinusAllQuantity(data.id, obj1).subscribe(d => {
          if (d) {
            data.productqty = d.result.qty;
            let index = this.checkoutProductsArray.findIndex(p => p.id == data.id);
            this.total = this.total - this.checkoutProductsArray[index].productPrice;
            this.checkoutProductsArray.splice(index, 1);
          }
        });
      }

      showModal() {
        this.isVisible = true;
      }

      handleOk() {
        this.isVisible = false;
      }

      saveTransaction(reqUser, action) {
        debugger;
        this.objToPushForTransaction = [];
        console.log(this.checkoutProductsArray);
        this.checkoutProductsArray.forEach(prod => {
          let obj = {
            "product": prod,
            "quantity": prod.productQuantity
          };
          this.objToPushForTransaction.push(obj);
        });
        let request = {
          "amount": this.total,
          "requestedUser": reqUser,
          "action": action,
          "productTransactions": this.objToPushForTransaction
        };
        console.log(request);
        this.interactionServ.saveTransaction(request).subscribe(data => {
          if (action === "SC") {
            this.message.success('Transaction Completed', {
              nzDuration: 3000
            });
          }
        });

        if (action === "ROD") {
          this.checkoutProductsArray = [];
          this.total = 0;
          this.handleCancel();
        }
      }

      handleCancel() {
        this.isVisible = false;
        this.isVisible2 = false; // this.total = 0;
      }

      showModal2() {
        this.isVisible2 = true;
      }

      addProduct(obj) {
        // this.checking=true
        console.log(obj);
        this.interactionServ.getProductsById(obj["id"]).subscribe(d => {
          if (d) {
            obj.productqty = d.qty;
            console.log("==============Add Product===============", d.qty);
            console.log("==============Checking===============");
            this.checking = true;
            let index = this.checkoutProductsArray.findIndex(p => p.id == obj["id"]);
            var obj1 = {
              "qty": 0
            };

            if (obj.productqty != 0 && this.checking) {
              this.checking = false;
              console.log("==============IF===============");
              this.interactionServ.updateAddQuantity(obj["id"], obj).subscribe(d => {
                if (d) obj.productqty = d.result.qty;
              });
              let productPrice = obj.printProductPrice;
              this.total = this.total + productPrice;
              this.checkoutProductsArray[index].productPrice += productPrice;
              this.checkoutProductsArray[index]["productQuantity"] += 1;
            }
          }
        });
      }

      removeProduct(obj) {
        let obj1 = {
          "quantity": 0,
          "count": obj.productQuantity
        }; // this.checkingMinusCall=true;

        this.interactionServ.updateMinusQuantity(obj["id"], obj1).subscribe(d => {
          if (d) {
            this.checkingMinusCall = true;
            obj.productqty = d.result.qty;
            console.log("============== d of Minus Call  ===============", d);

            if (this.checkingMinusCall) {
              console.log("==============IF Of Minus===============");
              this.checkingMinusCall = false;
              let index = this.checkoutProductsArray.findIndex(p => p.id == obj["id"]);
              let productPrice = obj.printProductPrice;
              this.total = this.total - productPrice;
              this.checkoutProductsArray[index].productPrice = this.checkoutProductsArray[index].productPrice - productPrice;

              if (this.checkoutProductsArray[index]['productQuantity'] <= 1) {
                this.checkoutProductsArray.splice(index, 1);
              } else {
                this.checkoutProductsArray[index]["productQuantity"] -= 1;
              }
            }
          }
        });
      }

      checkingQunatity(data) {
        if (data.productqty > 0) {
          return true;
        } else {
          return false;
        }
      }

      disableButton() {
        if (!this.checkOutObj.name) {
          return true;
        } else {
          return false;
        }
      }

      print(reqUser, action) {
        this.saveTransaction(reqUser, action); // let printContents, popupWin;
        // printContents = document.getElementById('print-section').innerHTML;
        // popupWin = window.open('', '_blank', 'top=0,left=0,height=100%,width=auto');
        // popupWin.document.open();
        // popupWin.document.write(`
        //     <html>
        //       <head>
        //         <title>Print tab</title>
        //         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        //         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        //         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        //         </head>
        //   <body onload="window.print();window.close()">${printContents}</body>
        //     </html>`
        // );
        // popupWin.window.print();
        // popupWin.document.close();

        this.checkoutProductsArray = [];
        this.total = 0;
        this.handleCancel();

        if (action == "ROD") {
          this.message.success("Request Sent to  ".concat(reqUser), {
            nzDuration: 3000
          });
          this.isVisible1 = false;
        }
      }

      populateCols() {
        this.cols = [{
          header: "Product Name"
        }, {
          header: "Product Price"
        }, {
          header: "Product Quantity"
        }, {
          header: "Price"
        }];
      }

      postProduct() {
        this.interactionServ.postRequestedProduct(this.checkOutObj).subscribe(d => {
          this.message.success('Requested Product saved successfully', {
            nzDuration: 3000
          });
          this.checkOutObj.name = "";
        });
      }

      onChange(e) {
        const value = e.target.value;

        if (value != null && value != "") {
          this.getRequestForProductCount(value);
          this.options = this.requestProduct;
        }
      }

      getRequestForProductCount(value) {
        this.interactionServ.getRequestForProductCount(value).subscribe(d => {
          this.requestProduct = d.result; ////  .log(this.requestProduct);
        });
      }

      navigateToUserSelection() {
        this.router.navigate(['admin/userselection']);
      }

      func(username) {
        this.buttonDisable = true;
        this.saveTransaction(username, "ROD");
        this.message.success('Request Sent', {
          nzDuration: 3000
        });
        this.isVisible1 = false;
      }

      showModal1() {
        this.interactionServ.getUsers().subscribe(d => {
          if (d) {
            console.log("Helllo", d);
            this.user = d.result;
            this.user = this.user.filter(user => user.userType === "DESK");
            this.isVisible1 = true;
            this.isVisible = false;
          }
        });
      }

      handleOk1() {
        console.log('Button ok clicked!');
        this.isVisible1 = false;
      }

      handleCancel1() {
        console.log('Button cancel clicked!');
        this.isVisible1 = false;
      }

      postTransaction(request) {}

    };

    CheckoutComponent.ctorParameters = () => [{
      type: _main_screen_mainscreen_service__WEBPACK_IMPORTED_MODULE_2__["MainscreenService"]
    }, {
      type: ng_zorro_antd_message__WEBPACK_IMPORTED_MODULE_4__["NzMessageService"]
    }, {
      type: _angular_router__WEBPACK_IMPORTED_MODULE_5__["Router"]
    }, {
      type: _angular_router__WEBPACK_IMPORTED_MODULE_5__["ActivatedRoute"]
    }];

    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["HostListener"])("window:beforeunload", ["$event"])], CheckoutComponent.prototype, "unloadHandler", null);
    CheckoutComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
      selector: "app-checkout",
      template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(
      /*! raw-loader!./checkout.component.html */
      "./node_modules/raw-loader/dist/cjs.js!./src/app/checkout/checkout.component.html")).default,
      styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(
      /*! ./checkout.component.css */
      "./src/app/checkout/checkout.component.css")).default]
    })], CheckoutComponent);
    /***/
  },

  /***/
  "./src/app/login-page/User.ts":
  /*!************************************!*\
    !*** ./src/app/login-page/User.ts ***!
    \************************************/

  /*! exports provided: User */

  /***/
  function srcAppLoginPageUserTs(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "User", function () {
      return User;
    });
    /* harmony import */


    var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
    /*! tslib */
    "./node_modules/tslib/tslib.es6.js");

    class User {}
    /***/

  },

  /***/
  "./src/app/login-page/login-page.component.css":
  /*!*****************************************************!*\
    !*** ./src/app/login-page/login-page.component.css ***!
    \*****************************************************/

  /*! exports provided: default */

  /***/
  function srcAppLoginPageLoginPageComponentCss(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony default export */


    __webpack_exports__["default"] = ".login-container{\r\n    margin-top: 5%;\r\n    margin-bottom: 5%;\r\n}\r\n.login-form-1{\r\n    padding: 5%;\r\n    box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);\r\n}\r\n.login-form-1 h3{\r\n    text-align: center;\r\n    color: #333;\r\n}\r\n.login-form-2{\r\n    padding: 5%;\r\n    background: #0062cc;\r\n    box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);\r\n}\r\n.login-form-2 h3{\r\n    text-align: center;\r\n    color: #fff;\r\n}\r\n.login-container form{\r\n    padding: 10%;\r\n}\r\n.btnSubmit\r\n{\r\n    width: 50%;\r\n    border-radius: 1rem;\r\n    padding: 1.5%;\r\n    border: none;\r\n    cursor: pointer;\r\n}\r\n.login-form-1 .btnSubmit{\r\n    font-weight: 600;\r\n    color: #fff;\r\n    background-color: #0062cc;\r\n}\r\n.login-form-2 .btnSubmit{\r\n    font-weight: 600;\r\n    color: #0062cc;\r\n    background-color: #fff;\r\n}\r\n.login-form-2 .ForgetPwd{\r\n    color: #fff;\r\n    font-weight: 600;\r\n    text-decoration: none;\r\n}\r\n.login-form-1 .ForgetPwd{\r\n    color: #0062cc;\r\n    font-weight: 600;\r\n    text-decoration: none;\r\n}\r\nnz-spin {\r\n    display: inline-block;\r\n    \r\n\r\n  }\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbG9naW4tcGFnZS9sb2dpbi1wYWdlLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7SUFDSSxjQUFjO0lBQ2QsaUJBQWlCO0FBQ3JCO0FBQ0E7SUFDSSxXQUFXO0lBQ1gsNEVBQTRFO0FBQ2hGO0FBQ0E7SUFDSSxrQkFBa0I7SUFDbEIsV0FBVztBQUNmO0FBQ0E7SUFDSSxXQUFXO0lBQ1gsbUJBQW1CO0lBQ25CLDRFQUE0RTtBQUNoRjtBQUNBO0lBQ0ksa0JBQWtCO0lBQ2xCLFdBQVc7QUFDZjtBQUNBO0lBQ0ksWUFBWTtBQUNoQjtBQUNBOztJQUVJLFVBQVU7SUFDVixtQkFBbUI7SUFDbkIsYUFBYTtJQUNiLFlBQVk7SUFDWixlQUFlO0FBQ25CO0FBQ0E7SUFDSSxnQkFBZ0I7SUFDaEIsV0FBVztJQUNYLHlCQUF5QjtBQUM3QjtBQUNBO0lBQ0ksZ0JBQWdCO0lBQ2hCLGNBQWM7SUFDZCxzQkFBc0I7QUFDMUI7QUFDQTtJQUNJLFdBQVc7SUFDWCxnQkFBZ0I7SUFDaEIscUJBQXFCO0FBQ3pCO0FBQ0E7SUFDSSxjQUFjO0lBQ2QsZ0JBQWdCO0lBQ2hCLHFCQUFxQjtBQUN6QjtBQUVBO0lBQ0kscUJBQXFCOzs7RUFHdkIiLCJmaWxlIjoic3JjL2FwcC9sb2dpbi1wYWdlL2xvZ2luLXBhZ2UuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5sb2dpbi1jb250YWluZXJ7XHJcbiAgICBtYXJnaW4tdG9wOiA1JTtcclxuICAgIG1hcmdpbi1ib3R0b206IDUlO1xyXG59XHJcbi5sb2dpbi1mb3JtLTF7XHJcbiAgICBwYWRkaW5nOiA1JTtcclxuICAgIGJveC1zaGFkb3c6IDAgNXB4IDhweCAwIHJnYmEoMCwgMCwgMCwgMC4yKSwgMCA5cHggMjZweCAwIHJnYmEoMCwgMCwgMCwgMC4xOSk7XHJcbn1cclxuLmxvZ2luLWZvcm0tMSBoM3tcclxuICAgIHRleHQtYWxpZ246IGNlbnRlcjtcclxuICAgIGNvbG9yOiAjMzMzO1xyXG59XHJcbi5sb2dpbi1mb3JtLTJ7XHJcbiAgICBwYWRkaW5nOiA1JTtcclxuICAgIGJhY2tncm91bmQ6ICMwMDYyY2M7XHJcbiAgICBib3gtc2hhZG93OiAwIDVweCA4cHggMCByZ2JhKDAsIDAsIDAsIDAuMiksIDAgOXB4IDI2cHggMCByZ2JhKDAsIDAsIDAsIDAuMTkpO1xyXG59XHJcbi5sb2dpbi1mb3JtLTIgaDN7XHJcbiAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XHJcbiAgICBjb2xvcjogI2ZmZjtcclxufVxyXG4ubG9naW4tY29udGFpbmVyIGZvcm17XHJcbiAgICBwYWRkaW5nOiAxMCU7XHJcbn1cclxuLmJ0blN1Ym1pdFxyXG57XHJcbiAgICB3aWR0aDogNTAlO1xyXG4gICAgYm9yZGVyLXJhZGl1czogMXJlbTtcclxuICAgIHBhZGRpbmc6IDEuNSU7XHJcbiAgICBib3JkZXI6IG5vbmU7XHJcbiAgICBjdXJzb3I6IHBvaW50ZXI7XHJcbn1cclxuLmxvZ2luLWZvcm0tMSAuYnRuU3VibWl0e1xyXG4gICAgZm9udC13ZWlnaHQ6IDYwMDtcclxuICAgIGNvbG9yOiAjZmZmO1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogIzAwNjJjYztcclxufVxyXG4ubG9naW4tZm9ybS0yIC5idG5TdWJtaXR7XHJcbiAgICBmb250LXdlaWdodDogNjAwO1xyXG4gICAgY29sb3I6ICMwMDYyY2M7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjZmZmO1xyXG59XHJcbi5sb2dpbi1mb3JtLTIgLkZvcmdldFB3ZHtcclxuICAgIGNvbG9yOiAjZmZmO1xyXG4gICAgZm9udC13ZWlnaHQ6IDYwMDtcclxuICAgIHRleHQtZGVjb3JhdGlvbjogbm9uZTtcclxufVxyXG4ubG9naW4tZm9ybS0xIC5Gb3JnZXRQd2R7XHJcbiAgICBjb2xvcjogIzAwNjJjYztcclxuICAgIGZvbnQtd2VpZ2h0OiA2MDA7XHJcbiAgICB0ZXh0LWRlY29yYXRpb246IG5vbmU7XHJcbn1cclxuXHJcbm56LXNwaW4ge1xyXG4gICAgZGlzcGxheTogaW5saW5lLWJsb2NrO1xyXG4gICAgXHJcblxyXG4gIH0iXX0= */";
    /***/
  },

  /***/
  "./src/app/login-page/login-page.component.ts":
  /*!****************************************************!*\
    !*** ./src/app/login-page/login-page.component.ts ***!
    \****************************************************/

  /*! exports provided: LoginPageComponent */

  /***/
  function srcAppLoginPageLoginPageComponentTs(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "LoginPageComponent", function () {
      return LoginPageComponent;
    });
    /* harmony import */


    var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
    /*! tslib */
    "./node_modules/tslib/tslib.es6.js");
    /* harmony import */


    var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
    /*! @angular/core */
    "./node_modules/@angular/core/fesm2015/core.js");
    /* harmony import */


    var _User__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
    /*! ./User */
    "./src/app/login-page/User.ts");
    /* harmony import */


    var _main_screen_mainscreen_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
    /*! ../main-screen/mainscreen.service */
    "./src/app/main-screen/mainscreen.service.ts");
    /* harmony import */


    var ng_zorro_antd__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
    /*! ng-zorro-antd */
    "./node_modules/ng-zorro-antd/fesm2015/ng-zorro-antd.js");
    /* harmony import */


    var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
    /*! @angular/router */
    "./node_modules/@angular/router/fesm2015/router.js");
    /* harmony import */


    var _login__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(
    /*! ./login */
    "./src/app/login-page/login.ts");

    let LoginPageComponent = class LoginPageComponent {
      constructor(service, route, message) {
        this.service = service;
        this.route = route;
        this.message = message;
        this.isRegSpinning = false;
        this.isLogSpinning = false;
        this.login = 1;
        this.register = 0;
        this.registerModel = new _User__WEBPACK_IMPORTED_MODULE_2__["User"]();
        this.loginModel = new _login__WEBPACK_IMPORTED_MODULE_6__["login"]();
      }

      ngOnInit() {
        localStorage.clear();
        sessionStorage.clear();
      }

      gotoLogin() {
        this.register = 0;
        this.login = 1;
      }

      gotoRegister() {
        this.login = 0;
        this.register = 1;
      }

      submit(registerForm) {
        this.isRegSpinning = true;
        console.log(this.registerModel);
        this.registerModel.userType = 'USER';
        this.registerModel.password = '123';
        this.registerModel.active = true;
        this.registerModel.clientId = 1;
        this.service.registerUser(this.registerModel).subscribe(data => {
          if (data.result.status == 200) {
            console.log(data.result);
            this.message.success(data.result.message, {
              nzDuration: 3000
            });
            this.isRegSpinning = false;
          } else {
            console.log(data.result);
            this.message.error(data.result.message, {
              nzDuration: 3000
            });
            this.isRegSpinning = false;
          }
        });
      }

      loginSubmit(loginForm) {
        this.isLogSpinning = true;
        console.log(this.loginModel);
        this.loginModel.password = '123';
        this.loginModel.Role = 'USER';
        this.service.loginUser(this.loginModel).subscribe(res => {
          if (res) {
            if (res.status == 200) {
              console.log(res);
              sessionStorage.setItem('token', res.result.token);
              sessionStorage.setItem('username', res.result.username);
              sessionStorage.setItem('role', res.result.userType);
              this.route.navigate(['categories/products']);
              this.isLogSpinning = false;
              this.message.success('Login Successful', {
                nzDuration: 3000
              });
            }
          }
        }, error => {
          if (error) {
            this.message.error('Invalid Company ID', {
              nzDuration: 3000
            });
            this.isLogSpinning = false;
          }
        });
      }

      validate() {
        if (this.registerModel.name && this.registerModel.email) {
          return false;
        } else {
          return true;
        }
      }

      logValidate() {
        if (this.loginModel.username) {
          return false;
        } else {
          return true;
        }
      }

    };

    LoginPageComponent.ctorParameters = () => [{
      type: _main_screen_mainscreen_service__WEBPACK_IMPORTED_MODULE_3__["MainscreenService"]
    }, {
      type: _angular_router__WEBPACK_IMPORTED_MODULE_5__["Router"]
    }, {
      type: ng_zorro_antd__WEBPACK_IMPORTED_MODULE_4__["NzMessageService"]
    }];

    LoginPageComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
      selector: 'app-login-page',
      template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(
      /*! raw-loader!./login-page.component.html */
      "./node_modules/raw-loader/dist/cjs.js!./src/app/login-page/login-page.component.html")).default,
      styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(
      /*! ./login-page.component.css */
      "./src/app/login-page/login-page.component.css")).default]
    })], LoginPageComponent);
    /***/
  },

  /***/
  "./src/app/login-page/login.ts":
  /*!*************************************!*\
    !*** ./src/app/login-page/login.ts ***!
    \*************************************/

  /*! exports provided: login */

  /***/
  function srcAppLoginPageLoginTs(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "login", function () {
      return login;
    });
    /* harmony import */


    var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
    /*! tslib */
    "./node_modules/tslib/tslib.es6.js");

    class login {}
    /***/

  },

  /***/
  "./src/app/main-screen/main-screen.component.css":
  /*!*******************************************************!*\
    !*** ./src/app/main-screen/main-screen.component.css ***!
    \*******************************************************/

  /*! exports provided: default */

  /***/
  function srcAppMainScreenMainScreenComponentCss(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony default export */


    __webpack_exports__["default"] = ".trigger {\r\n    font-size: 18px;\r\n    line-height: 64px;\r\n    padding: 0 24px;\r\n    cursor: pointer;\r\n    -webkit-transition: color 0.3s;\r\n    transition: color 0.3s;\r\n  }\r\n\r\n  .trigger:hover {\r\n    color: #1890ff;\r\n  }\r\n\r\n  .logo {\r\n    width: 120px;\r\n    height: 31px;\r\n    background: rgba(255, 255, 255, 0.2);\r\n    margin: 16px 24px 16px 0;\r\n    float: left;\r\n  }\r\n\r\n  [nz-menu] {\r\n    line-height: 64px;\r\n  }\r\n\r\n  nz-header {\r\n    background: #fff;\r\n    padding: 0;\r\n  }\r\n\r\n  nz-content {\r\n    margin: 0 16px;\r\n  }\r\n\r\n  nz-breadcrumb {\r\n    margin: 16px 0;\r\n  }\r\n\r\n  .inner-content {\r\n    padding: 24px;\r\n    background: #fff;\r\n    min-height: 610px;\r\n  }\r\n\r\n  nz-footer {\r\n    text-align: center;\r\n  }\r\n\r\n  \r\n  \r\n \r\n \r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbWFpbi1zY3JlZW4vbWFpbi1zY3JlZW4uY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtJQUNJLGVBQWU7SUFDZixpQkFBaUI7SUFDakIsZUFBZTtJQUNmLGVBQWU7SUFDZiw4QkFBc0I7SUFBdEIsc0JBQXNCO0VBQ3hCOztFQUVBO0lBQ0UsY0FBYztFQUNoQjs7RUFFQTtJQUNFLFlBQVk7SUFDWixZQUFZO0lBQ1osb0NBQW9DO0lBQ3BDLHdCQUF3QjtJQUN4QixXQUFXO0VBQ2I7O0VBRUE7SUFDRSxpQkFBaUI7RUFDbkI7O0VBRUE7SUFDRSxnQkFBZ0I7SUFDaEIsVUFBVTtFQUNaOztFQUVBO0lBQ0UsY0FBYztFQUNoQjs7RUFFQTtJQUNFLGNBQWM7RUFDaEI7O0VBRUE7SUFDRSxhQUFhO0lBQ2IsZ0JBQWdCO0lBQ2hCLGlCQUFpQjtFQUNuQjs7RUFFQTtJQUNFLGtCQUFrQjtFQUNwQiIsImZpbGUiOiJzcmMvYXBwL21haW4tc2NyZWVuL21haW4tc2NyZWVuLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIudHJpZ2dlciB7XHJcbiAgICBmb250LXNpemU6IDE4cHg7XHJcbiAgICBsaW5lLWhlaWdodDogNjRweDtcclxuICAgIHBhZGRpbmc6IDAgMjRweDtcclxuICAgIGN1cnNvcjogcG9pbnRlcjtcclxuICAgIHRyYW5zaXRpb246IGNvbG9yIDAuM3M7XHJcbiAgfVxyXG5cclxuICAudHJpZ2dlcjpob3ZlciB7XHJcbiAgICBjb2xvcjogIzE4OTBmZjtcclxuICB9XHJcblxyXG4gIC5sb2dvIHtcclxuICAgIHdpZHRoOiAxMjBweDtcclxuICAgIGhlaWdodDogMzFweDtcclxuICAgIGJhY2tncm91bmQ6IHJnYmEoMjU1LCAyNTUsIDI1NSwgMC4yKTtcclxuICAgIG1hcmdpbjogMTZweCAyNHB4IDE2cHggMDtcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG4gIH1cclxuXHJcbiAgW256LW1lbnVdIHtcclxuICAgIGxpbmUtaGVpZ2h0OiA2NHB4O1xyXG4gIH1cclxuXHJcbiAgbnotaGVhZGVyIHtcclxuICAgIGJhY2tncm91bmQ6ICNmZmY7XHJcbiAgICBwYWRkaW5nOiAwO1xyXG4gIH1cclxuXHJcbiAgbnotY29udGVudCB7XHJcbiAgICBtYXJnaW46IDAgMTZweDtcclxuICB9XHJcblxyXG4gIG56LWJyZWFkY3J1bWIge1xyXG4gICAgbWFyZ2luOiAxNnB4IDA7XHJcbiAgfVxyXG5cclxuICAuaW5uZXItY29udGVudCB7XHJcbiAgICBwYWRkaW5nOiAyNHB4O1xyXG4gICAgYmFja2dyb3VuZDogI2ZmZjtcclxuICAgIG1pbi1oZWlnaHQ6IDYxMHB4O1xyXG4gIH1cclxuXHJcbiAgbnotZm9vdGVyIHtcclxuICAgIHRleHQtYWxpZ246IGNlbnRlcjtcclxuICB9XHJcblxyXG4gIFxyXG4gIFxyXG4gXHJcbiAiXX0= */";
    /***/
  },

  /***/
  "./src/app/main-screen/main-screen.component.ts":
  /*!******************************************************!*\
    !*** ./src/app/main-screen/main-screen.component.ts ***!
    \******************************************************/

  /*! exports provided: MainScreenComponent */

  /***/
  function srcAppMainScreenMainScreenComponentTs(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "MainScreenComponent", function () {
      return MainScreenComponent;
    });
    /* harmony import */


    var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
    /*! tslib */
    "./node_modules/tslib/tslib.es6.js");
    /* harmony import */


    var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
    /*! @angular/core */
    "./node_modules/@angular/core/fesm2015/core.js");
    /* harmony import */


    var _mainscreen_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
    /*! ./mainscreen.service */
    "./src/app/main-screen/mainscreen.service.ts");
    /* harmony import */


    var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
    /*! @angular/router */
    "./node_modules/@angular/router/fesm2015/router.js");

    let MainScreenComponent = class MainScreenComponent {
      constructor(mainScreenServ, activeRoute, router) {
        this.mainScreenServ = mainScreenServ;
        this.activeRoute = activeRoute;
        this.router = router; // mobileView = true;

        this.CollapsedNav = true;
        this.categoriesArray = [] = [];
      }

      ngOnInit() {
        this.innerWidth = window.innerWidth; // this.setupMobileView();

        this.userName = sessionStorage.getItem('username');
        this.router.navigate(["categories/products"]);
        this.getCat();
      }

      getCat() {
        this.mainScreenServ.getCategories().subscribe(d => {
          this.categoriesArray = d;
        });
      }

      addCategoryToUrl(urlFilterWithCatName) {
        this.router.navigate(["categories/" + urlFilterWithCatName]);
      }

      showModal() {
        this.isVisible = true;
      }

      handleOk() {
        this.isVisible = false;
      }

      handleCancel() {
        this.isVisible = false;
      }

      navigateBackToLoginPage() {
        this.router.navigate(['login']);
      }

    };

    MainScreenComponent.ctorParameters = () => [{
      type: _mainscreen_service__WEBPACK_IMPORTED_MODULE_2__["MainscreenService"]
    }, {
      type: _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"]
    }, {
      type: _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"]
    }];

    MainScreenComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
      selector: 'app-main-screen',
      template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(
      /*! raw-loader!./main-screen.component.html */
      "./node_modules/raw-loader/dist/cjs.js!./src/app/main-screen/main-screen.component.html")).default,
      styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(
      /*! ./main-screen.component.css */
      "./src/app/main-screen/main-screen.component.css")).default]
    })], MainScreenComponent);
    /***/
  },

  /***/
  "./src/app/main-screen/mainscreen.service.ts":
  /*!***************************************************!*\
    !*** ./src/app/main-screen/mainscreen.service.ts ***!
    \***************************************************/

  /*! exports provided: MainscreenService */

  /***/
  function srcAppMainScreenMainscreenServiceTs(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "MainscreenService", function () {
      return MainscreenService;
    });
    /* harmony import */


    var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
    /*! tslib */
    "./node_modules/tslib/tslib.es6.js");
    /* harmony import */


    var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
    /*! @angular/core */
    "./node_modules/@angular/core/fesm2015/core.js");
    /* harmony import */


    var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
    /*! @angular/common/http */
    "./node_modules/@angular/common/fesm2015/http.js");
    /* harmony import */


    var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
    /*! rxjs */
    "./node_modules/rxjs/_esm2015/index.js");
    /* harmony import */


    var src_environments_environment__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
    /*! src/environments/environment */
    "./src/environments/environment.ts");

    let MainscreenService = class MainscreenService {
      // private productQuantityUpdateToCheckout = new Subject<any>();
      // productQuantityUpdateToCheckout$= this.productQuantityUpdateToCheckout.asObservable();
      constructor(http) {
        this.http = http;
        this.productSource = new rxjs__WEBPACK_IMPORTED_MODULE_3__["Subject"]();
        this.productMessage$ = this.productSource.asObservable();
        this.productQuantityUpdateToProductListing = new rxjs__WEBPACK_IMPORTED_MODULE_3__["Subject"]();
        this.productQuantityUpdateToProductListing$ = this.productQuantityUpdateToProductListing.asObservable();
        this.getCategoriesURL = src_environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].baseUrl + "api/category/";
        this.getProductsURL = src_environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].baseUrl + "api/products/category/";
        this.postRequestedProductURL = src_environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].baseUrl + "api/products/postreqproduct";
        this.getRecenttransactionsURL = src_environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].baseUrl + "api/transaction/recent-transactions";
        this.getAutoCompleteRequestURL = src_environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].baseUrl + "api/dashboard/autocomplete/";
        this.getAllProductURL = src_environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].baseUrl + "api/products/";
        this.getSettingURL = src_environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].baseUrl + "api/dashboard/settings";
        this.postTransactionURL = src_environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].baseUrl + "api/transaction/post"; // private getAutoCompleteRequestURL = environment.baseUrl + "api/dashboard/autocomplete/";
        // private getAllProductURL = environment.baseUrl + "api/products/";
        // private getSettingURL = environment.baseUrl + "api/dashboard/settings";
        // private postTransactionURL = environment.baseUrl + "api/transaction/post";

        this.updateAddQuantityURL = src_environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].baseUrl + "api/products/add";
        this.updateMinusQuantityURL = src_environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].baseUrl + "api/products/minus";
        this.updateMinusAllQuantityURL = src_environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].baseUrl + "api/products/minusall";
        this.registeruserURL = src_environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].baseUrl + "token/user";
        this.loginUserURL = src_environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].baseUrl + "token/generate-token";
        this.searchProductByKeywordURL = src_environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].baseUrl + "api/products/search/";
        this.getUsersURL = src_environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].baseUrl + "api/user/";
      }

      sendMessage(obj) {
        this.productSource.next(obj);
      }

      sendQuantityUpdateToProductListing(obj) {
        this.productQuantityUpdateToProductListing.next(obj);
      } // public sendQuantityUpdateToCheckout(obj){
      //   this.productQuantityUpdateToCheckout.next(obj);
      // }


      getCategories() {
        return this.http.get(this.getCategoriesURL);
      }

      getProducts(urlFilter) {
        return this.http.get(this.getProductsURL + urlFilter);
      }

      postRequestedProduct(Obj) {
        return this.http.post(this.postRequestedProductURL, Obj);
      }

      saveTransaction(transaction) {
        return this.http.post(this.postTransactionURL, transaction);
      }

      getRequestForProductCount(keyword) {
        return this.http.get(this.getAutoCompleteRequestURL + keyword);
      } // public getAllProducts(): Observable<any> {
      //   return this.http.get(this.getAllProductURL);


      getAllProducts() {
        return this.http.get(this.getAllProductURL);
      }

      getProductsById(id) {
        return this.http.get(this.getAllProductURL + id);
      }

      getSetting() {
        return this.http.get(this.getSettingURL);
      }

      recentTransactions() {
        return this.http.get(this.getRecenttransactionsURL);
      }

      updateAddQuantity(id, product) {
        return this.http.put(this.updateAddQuantityURL + '/' + id, product);
      }

      updateMinusQuantity(id, product) {
        return this.http.put(this.updateMinusQuantityURL + '/' + id, product);
      }

      updateMinusAllQuantity(id, product) {
        return this.http.put(this.updateMinusAllQuantityURL + '/' + id, product);
      }

      registerUser(user) {
        return this.http.post(this.registeruserURL, user);
      }

      loginUser(login) {
        return this.http.post(this.loginUserURL, login);
      }

      loggedIn() {
        return !!sessionStorage.getItem('token');
      }

      userRole() {
        if (sessionStorage.getItem('role') == 'USER') {
          return true;
        } else {
          return false;
        }
      }

      adminRole() {
        if (sessionStorage.getItem('role') == 'ADMIN') {
          return true;
        } else {
          return false;
        }
      }

      searchProductByKeyword(keyword) {
        return this.http.get(this.searchProductByKeywordURL + keyword);
      }

      getUsers() {
        return this.http.get(this.getUsersURL);
      }

    };

    MainscreenService.ctorParameters = () => [{
      type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]
    }];

    MainscreenService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
      providedIn: 'root'
    })], MainscreenService);
    /***/
  },

  /***/
  "./src/app/product-listing/product-listing.component.css":
  /*!***************************************************************!*\
    !*** ./src/app/product-listing/product-listing.component.css ***!
    \***************************************************************/

  /*! exports provided: default */

  /***/
  function srcAppProductListingProductListingComponentCss(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony default export */


    __webpack_exports__["default"] = "#cardShadow{\r\n    /* border: 1px solid; */\r\n    padding: 10px;\r\n    box-shadow: 5px 10px 18px #888888;\r\n  }\r\n\r\n\r\n  .certain-search-item-count {\r\n    position: absolute;\r\n    color: #999;\r\n    right: 16px;\r\n  }\r\n\r\n\r\n  .more-link {\r\n    float: right;\r\n  }\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcHJvZHVjdC1saXN0aW5nL3Byb2R1Y3QtbGlzdGluZy5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0lBQ0ksdUJBQXVCO0lBQ3ZCLGFBQWE7SUFDYixpQ0FBaUM7RUFDbkM7OztFQUdBO0lBQ0Usa0JBQWtCO0lBQ2xCLFdBQVc7SUFDWCxXQUFXO0VBQ2I7OztFQUVBO0lBQ0UsWUFBWTtFQUNkIiwiZmlsZSI6InNyYy9hcHAvcHJvZHVjdC1saXN0aW5nL3Byb2R1Y3QtbGlzdGluZy5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiI2NhcmRTaGFkb3d7XHJcbiAgICAvKiBib3JkZXI6IDFweCBzb2xpZDsgKi9cclxuICAgIHBhZGRpbmc6IDEwcHg7XHJcbiAgICBib3gtc2hhZG93OiA1cHggMTBweCAxOHB4ICM4ODg4ODg7XHJcbiAgfVxyXG5cclxuXHJcbiAgLmNlcnRhaW4tc2VhcmNoLWl0ZW0tY291bnQge1xyXG4gICAgcG9zaXRpb246IGFic29sdXRlO1xyXG4gICAgY29sb3I6ICM5OTk7XHJcbiAgICByaWdodDogMTZweDtcclxuICB9XHJcblxyXG4gIC5tb3JlLWxpbmsge1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG4gIH0iXX0= */";
    /***/
  },

  /***/
  "./src/app/product-listing/product-listing.component.ts":
  /*!**************************************************************!*\
    !*** ./src/app/product-listing/product-listing.component.ts ***!
    \**************************************************************/

  /*! exports provided: ProductListingComponent */

  /***/
  function srcAppProductListingProductListingComponentTs(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "ProductListingComponent", function () {
      return ProductListingComponent;
    });
    /* harmony import */


    var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
    /*! tslib */
    "./node_modules/tslib/tslib.es6.js");
    /* harmony import */


    var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
    /*! @angular/core */
    "./node_modules/@angular/core/fesm2015/core.js");
    /* harmony import */


    var _main_screen_mainscreen_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
    /*! ../main-screen/mainscreen.service */
    "./src/app/main-screen/mainscreen.service.ts");
    /* harmony import */


    var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
    /*! @angular/router */
    "./node_modules/@angular/router/fesm2015/router.js");

    let ProductListingComponent = class ProductListingComponent {
      constructor(prodService, activeRoute) {
        this.prodService = prodService;
        this.activeRoute = activeRoute;
        this.productsArray = [] = [];
        this.count = 0;
        this.checking = true;
        this.checking1 = true;
      }

      ngOnInit() {
        // this.prodService.productQuantityUpdateToProductListing$.subscribe(d => {
        //   let index = this.productsArray.findIndex(prod => {
        //     return prod.name == d.productTitle
        //   });
        //   this.productsArray[index].qty = d.productqty;
        // })
        this.activeRoute.paramMap.subscribe(params => {
          this.getProducts(params['params'].category);
          this.categoryHeader = params['params'].category;
        });
        this.getAllProducts();
      }

      getProducts(str) {
        if (str === "products") {
          this.getAllProducts();
        } else {
          this.prodService.getProducts(str).subscribe(d => {
            if (d) {
              d.result = d.result.filter(e => e.qty > 0);
              this.productsArray = d.result;
              console.log(this.productsArray);
            }
          });
        }
      }

      sendProducttoCheckout(prod, card) {
        this.prodService.getProductsById(prod.id).subscribe(d => {
          if (d) {
            prod.qty = d.qty;
            console.log("==============Send Product To Checkout===============", d.qty);
            this.checking1 = true;

            if (prod.qty == 0 && this.checking1) {
              this.checking1 = false;
              console.log("==============IF===============");
            } else if (this.checking1) {
              console.log("==============ELSE===============");
              this.checking1 = false;
              var obj = {
                "qty": prod.qty
              };
              this.prodService.updateAddQuantity(prod.id, obj).subscribe(d => {
                // //console.log(d);
                if (d) {
                  prod.qty = d.result.qty;
                  this.checking = true;
                }

                console.log(prod);

                if (this.checking) {
                  this.prodService.sendMessage(prod);
                  this.checking = false;
                }
              });
            }
          }
        });
      }

      getAllProducts() {
        this.prodService.getAllProducts().subscribe(d => {
          if (d) {
            d = d.filter(e => e.qty > 0);
            this.productsArray = d;
          }
        });
      }

      searchProductByKeyword(value) {
        this.prodService.searchProductByKeyword(value).subscribe(d => {
          if (d) {
            this.searchProduct = d.result;
            this.productsArray = this.searchProduct;
          }
        });
      }

      onChange(value) {
        //const value = (e.target as HTMLInputElement).value;
        if (value != null && value != "") {
          this.searchProductByKeyword(value); //this.productsArray = this.searchProduct;
          //console.log(this.productsArray)
        } else {
          this.getAllProducts();
        }
      }

    };

    ProductListingComponent.ctorParameters = () => [{
      type: _main_screen_mainscreen_service__WEBPACK_IMPORTED_MODULE_2__["MainscreenService"]
    }, {
      type: _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"]
    }];

    ProductListingComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
      selector: 'app-product-listing',
      template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(
      /*! raw-loader!./product-listing.component.html */
      "./node_modules/raw-loader/dist/cjs.js!./src/app/product-listing/product-listing.component.html")).default,
      styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(
      /*! ./product-listing.component.css */
      "./src/app/product-listing/product-listing.component.css")).default]
    })], ProductListingComponent);
    /***/
  },

  /***/
  "./src/app/recent-transactions/recent-transactions.component.css":
  /*!***********************************************************************!*\
    !*** ./src/app/recent-transactions/recent-transactions.component.css ***!
    \***********************************************************************/

  /*! exports provided: default */

  /***/
  function srcAppRecentTransactionsRecentTransactionsComponentCss(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony default export */


    __webpack_exports__["default"] = ".cardShadow{\r\n    \r\n    \r\n    box-shadow: 5px 10px 18px #888888;\r\n    \r\n  }\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcmVjZW50LXRyYW5zYWN0aW9ucy9yZWNlbnQtdHJhbnNhY3Rpb25zLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7OztJQUdJLGlDQUFpQzs7RUFFbkMiLCJmaWxlIjoic3JjL2FwcC9yZWNlbnQtdHJhbnNhY3Rpb25zL3JlY2VudC10cmFuc2FjdGlvbnMuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5jYXJkU2hhZG93e1xyXG4gICAgXHJcbiAgICBcclxuICAgIGJveC1zaGFkb3c6IDVweCAxMHB4IDE4cHggIzg4ODg4ODtcclxuICAgIFxyXG4gIH0iXX0= */";
    /***/
  },

  /***/
  "./src/app/recent-transactions/recent-transactions.component.ts":
  /*!**********************************************************************!*\
    !*** ./src/app/recent-transactions/recent-transactions.component.ts ***!
    \**********************************************************************/

  /*! exports provided: RecentTransactionsComponent */

  /***/
  function srcAppRecentTransactionsRecentTransactionsComponentTs(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "RecentTransactionsComponent", function () {
      return RecentTransactionsComponent;
    });
    /* harmony import */


    var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
    /*! tslib */
    "./node_modules/tslib/tslib.es6.js");
    /* harmony import */


    var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
    /*! @angular/core */
    "./node_modules/@angular/core/fesm2015/core.js");
    /* harmony import */


    var _main_screen_mainscreen_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
    /*! ../main-screen/mainscreen.service */
    "./src/app/main-screen/mainscreen.service.ts");

    let RecentTransactionsComponent = class RecentTransactionsComponent {
      constructor(prodService) {
        this.prodService = prodService;
        this.data = [];
        this.productsarray = [];
        this.isVisible = false;
      }

      ngOnInit() {
        this.gettingRecentTransactions(); // this.data = d;
        //   console.log(res);
        //   if (res) {
        //     let countArray;
        //     this.data = res.map((value, index) => {
        //       value.countArray = [];
        //       this.data.push(value)
        //       countArray = [];
        //       value.products.map((d) => {
        //         if (!countArray.find((a) => d.name == a.name)) {
        //           let countObj = {
        //             name: d.name,
        //             count: 1
        //           }
        //           countArray.push(countObj);
        //         }
        //         else {
        //           countArray = countArray.map((a) => {
        //             if (a.name == d.name)
        //               a.count++;
        //             return a;
        //           });
        //         }
        //       })
        //       let newData = value;
        //       newData.countArray = countArray;
        //       return newData;
        //     })
        //     // console.log(countArray,"===================");
        //     console.log(this.data, "==============newdata");
        //   }
        // })
      }

      gettingRecentTransactions() {
        this.prodService.recentTransactions().subscribe(response => {
          console.log(response);
          this.data = response;
        });
      }

      showproducts(productTransaction) {
        this.productsarray = productTransaction;
        this.isVisible = true;
      }

      handleOk() {
        this.isVisible = false;
      }

      handleCancel() {
        this.isVisible = false;
      }

      checking() {
        if (this.data.length > 0 && this.data) {
          return true;
        }

        return false;
      }

    };

    RecentTransactionsComponent.ctorParameters = () => [{
      type: _main_screen_mainscreen_service__WEBPACK_IMPORTED_MODULE_2__["MainscreenService"]
    }];

    RecentTransactionsComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
      selector: 'app-recent-transactions',
      template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(
      /*! raw-loader!./recent-transactions.component.html */
      "./node_modules/raw-loader/dist/cjs.js!./src/app/recent-transactions/recent-transactions.component.html")).default,
      styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(
      /*! ./recent-transactions.component.css */
      "./src/app/recent-transactions/recent-transactions.component.css")).default]
    })], RecentTransactionsComponent);
    /***/
  },

  /***/
  "./src/app/request.intercepts.ts":
  /*!***************************************!*\
    !*** ./src/app/request.intercepts.ts ***!
    \***************************************/

  /*! exports provided: NoopInterceptor */

  /***/
  function srcAppRequestInterceptsTs(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "NoopInterceptor", function () {
      return NoopInterceptor;
    });
    /* harmony import */


    var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
    /*! tslib */
    "./node_modules/tslib/tslib.es6.js");
    /* harmony import */


    var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
    /*! @angular/core */
    "./node_modules/@angular/core/fesm2015/core.js");
    /* harmony import */


    var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
    /*! @angular/router */
    "./node_modules/@angular/router/fesm2015/router.js"); // import { nextContext } from "@angular/core/src/render3";


    let NoopInterceptor = class NoopInterceptor {
      constructor(router) {
        this.router = router;
        this.url = this.router.url;
      }

      intercept(req, next) {
        // console.log("hello interceptor");
        if (sessionStorage.length > 0) {
          const changedReq = req.clone({
            headers: req.headers.set('Authorization', sessionStorage.getItem('token'))
          });
          return next.handle(changedReq);
        } else {
          sessionStorage.clear();
          this.router.navigate(['']);
          const changedReq = req.clone({
            headers: req.headers.set('Content-Type', 'application/json')
          }); // const changedReq = req.clone();

          return next.handle(changedReq);
        }
      }

    };

    NoopInterceptor.ctorParameters = () => [{
      type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]
    }];

    NoopInterceptor = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])()], NoopInterceptor);
    /***/
  },

  /***/
  "./src/environments/environment.ts":
  /*!*****************************************!*\
    !*** ./src/environments/environment.ts ***!
    \*****************************************/

  /*! exports provided: environment */

  /***/
  function srcEnvironmentsEnvironmentTs(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */


    __webpack_require__.d(__webpack_exports__, "environment", function () {
      return environment;
    });
    /* harmony import */


    var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
    /*! tslib */
    "./node_modules/tslib/tslib.es6.js"); // This file can be replaced during build by using the `fileReplacements` array.
    // `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
    // The list of file replacements can be found in `angular.json`.


    const environment = {
      production: false,
      baseUrl: 'http://localhost:8080/'
    };
    /*
     * For easier debugging in development mode, you can import the following file
     * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
     *
     * This import should be commented out in production mode because it will have a negative impact
     * on performance if an error is thrown.
     */
    // import 'zone.js/dist/zone-error';  // Included with Angular CLI.

    /***/
  },

  /***/
  "./src/main.ts":
  /*!*********************!*\
    !*** ./src/main.ts ***!
    \*********************/

  /*! no exports provided */

  /***/
  function srcMainTs(module, __webpack_exports__, __webpack_require__) {
    "use strict";

    __webpack_require__.r(__webpack_exports__);
    /* harmony import */


    var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
    /*! tslib */
    "./node_modules/tslib/tslib.es6.js");
    /* harmony import */


    var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
    /*! @angular/core */
    "./node_modules/@angular/core/fesm2015/core.js");
    /* harmony import */


    var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
    /*! @angular/platform-browser-dynamic */
    "./node_modules/@angular/platform-browser-dynamic/fesm2015/platform-browser-dynamic.js");
    /* harmony import */


    var _app_app_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
    /*! ./app/app.module */
    "./src/app/app.module.ts");
    /* harmony import */


    var _environments_environment__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
    /*! ./environments/environment */
    "./src/environments/environment.ts");

    if (_environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].production) {
      Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["enableProdMode"])();
    }

    Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_2__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_3__["AppModule"]).catch(err => console.error(err));
    /***/
  },

  /***/
  0:
  /*!***************************!*\
    !*** multi ./src/main.ts ***!
    \***************************/

  /*! no static exports found */

  /***/
  function _(module, exports, __webpack_require__) {
    module.exports = __webpack_require__(
    /*! F:\TuckshopFrontend\TucShopApp\src\main.ts */
    "./src/main.ts");
    /***/
  }
}, [[0, "runtime", "vendor"]]]);
//# sourceMappingURL=main-es5.js.map