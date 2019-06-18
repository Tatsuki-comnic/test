<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="myapp">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <style>
      .wrap
      {
        width: 800px;
        max-width: 90%;
        margin: 10px auto;
      }
      .wrap div
      {
        margin: 2em 0;
      }
      .footer
      {
        margin-top: 40px;
        padding-top: 1em;
        border-top: 1px solid #dedede;
        text-align: right;
      }
    </style>
    <title>郵便番号 API</title>
  </head>
  <body ng-controller="app">
    <div class="wrap">
      <h1>郵便番号 API</h1>
      <p>この郵便番号APIはGitHubページを使用して静的なファイルで配信しているため信頼性が高く、さらにオープンソースなのでクライアントワークでも安心して使用できます。</p>

      <p>また、郵便番号から英語の住所を取得することも可能です。（大口事業所個別番号は英語には対応していません。）</p>
      <div class="form-inline">
      <span class="help-block" style="display: block;">郵便番号を入力してください。</span>
      <input type="text" class="form-control" placeholder="例: 1000014" ng-model="code" ng-change="input()"> <button ng-click="click()" class="btn btn-primary">住所を取得</button>
      </div>

      <div ng-if="data.error" class="alert alert-danger">住所が見つかりませんでした。</div>

      <div ng-if="! data.error &amp;&amp; !! data.url"><strong>Endpoint:</strong> <a ng-href="{{ data.url }}">{{ data.url }}</a></div>

      <div ng-repeat="address in data.addresses">
        <table class="table table-striped">
          <tr><th></th><th>prefecture</th><th>address1</th><th>address2</th><th>address3</th><th>address4</th></tr>
          <tr><th>ja</th><td>{{ address.ja.prefecture }}</td><td>{{ address.ja.address1 }}</td><td>{{ address.ja.address2 }}</td><td>{{ address.ja.address3 }}</td><td>{{ address.ja.address4 }}</td></tr>
          <tr><th>en</th><td>{{ address.en.prefecture }}</td><td>{{ address.en.address1 }}</td><td>{{ address.en.address2 }}</td><td>{{ address.en.address3 }}</td><td>{{ address.en.address4 }}</td></tr>
        </table>
      </div>

      <div ng-if="data.json"><pre>{{ data.json }}</pre></div>

      <div class="footer"><a href="https://github.com/madefor/postal-code-api/">Postal Code API</a> by <a href="https://github.com/madefor">Made for _____ Team</a></div>

      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
      <script type="text/javascript">
      angular.module('myapp', [])
      .service('getAddress', ['$http', function ($http) {
        this.getdata = function (url, callback) {
          $http({
            url: url,
            method: 'GET'
          })
          .success(function (data, status, headers, config) {
            callback(data);
          })
          .error(function () {
            callback({error: true});
          })
        };
      }])
      .controller('app', ['$scope', 'getAddress', function ($scope, getAddress) {
        $scope.input = function() {
          if ($scope.code && $scope.code.match(/^[0-9]{3}\-?[0-9]{4}$/)) {
            angular.element(document).find('button').attr('disabled', false);
          } else {
            angular.element(document).find('button').attr('disabled', true);
          }
        }
        $scope.click = function () {
          if ( ! $scope.code || ! $scope.code.match( /^[0-9]{3}\-?[0-9]{4}$/ ) ) {
            return;
          }
          var endpoint = 'https://madefor.github.io/postal-code-api/api/v1';
          var code1 = $scope.code.replace(/^([0-9]{3}).*/, "$1");
          var code2 = $scope.code.replace(/.*([0-9]{4})$/, "$1");
          $scope.data = {};
          $scope.data.url = endpoint + '/' + code1 +'/' + code2 + '.json';
          getAddress.getdata($scope.data.url, function (res) {
            if (res.error) {
              $scope.data.error = true;
            } else {
              $scope.data.json = json = JSON.stringify( res, null, "    " );
              $scope.data.addresses = res.data;
            }
          });
        }
      }]);
      </script>

    <div>
  </body>
</html>