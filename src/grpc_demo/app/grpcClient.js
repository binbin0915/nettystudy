//动态生成
var PROTO_FILE_PATH = "../proto/Xuesheng.proto";
var grpc = require("grpc");
//加包名
var grpcService = grpc.load(PROTO_FILE_PATH).cz.yb.proto;

var client = new grpcService.XueshengService("127.0.0.1:9988",grpc.credentials.createInsecure());

client.GetRealNameByUsername({username:"李雷"},function(err,respData) {
    console.log(respData);
});