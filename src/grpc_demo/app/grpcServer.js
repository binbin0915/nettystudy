//动态生成
var PROTO_FILE_PATH = "../proto/Xuesheng.proto";
var grpc = require("grpc");
//加包名
var grpcService = grpc.load(PROTO_FILE_PATH).cz.yb.proto;

var server = new grpc.Server();

server.addService(grpcService.XueshengService.service,{
    GetRealNameByUsername:GetRealNameByUsername
    ,GetStudentsByAge:GetStudentsByAge
    ,GetStudentsWrapperByAges:GetStudentsWrapperByAges
    ,biTalk:biTalk
});

server.bind("127.0.0.1:9988",grpc.ServerCredentials.createInsecure());
server.start();

function GetRealNameByUsername(call,callback){
    console.log("call:"+call.request.username);
    callback(null,{realname:"张三1"});
}

function GetStudentsByAge(){

}

function GetStudentsWrapperByAges(){
    
}

function biTalk(){
    
}
