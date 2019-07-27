var express = require('express');
var http = require('http');
var router = express.Router();

/* GET home page. */

router.post("/", function (req, res, next) {
    console.log(req);
    var proxy_host = process.env.HTTP_PROXY_HOST || 'service-edge.default.svc.cluster.local';
    var proxy_port = process.env.HTTP_PROXY_PORT || '13080'; // 13092

    var opt = {
        host: proxy_host,
        port: proxy_port,
        method: 'POST',
        path: '/rest/userservice/register?telNum=' + req.query.telNum + '&user=' + req.query.user,
        headers: {
        }
    };

    if (proxy_host === '127.0.0.1') {
        opt.path = '/mock/register.json';
    }

    console.log("path: " + opt.path);
    console.log("host: " + opt.host);
    console.log("port: " + opt.port);
    var body = '';
    var request = http.request(opt, function(response) {
        console.log("Got response: " + response.statusCode);
        response.on('data', function (d) {
            body += d;
        }).on('end', function () {
            // console.log(body);
            res.writeHead(200, {'Content-Type': 'application/text; charset=utf-8'});
            res.write(body);
            res.end();
        });
    }).on('error', function (e) {
        console.log("Got error: " + e.message);
    });
    request.end();
});


module.exports = router;
