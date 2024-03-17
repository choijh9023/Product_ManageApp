<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>read</title>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <!-- 기존의 <h1>Header</h1> -->
        <div class="row">
            <div class="col">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#">Navbar</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                            <div class="navbar-nav">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                                <a class="nav-link" href="#">Features</a>
                                <a class="nav-link" href="#">Pricing</a>
                                <a class="nav-link disabled">Disabled</a>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- header end -->
        <!-- 기존의 <h1>Header</h1>끝 -->

        <div class="row content">
            <div class="col">
                <div class="card">
                    <div class="card-header">
                        Featured
                    </div>
                    <div class="card-body">
                        <div class="input-group mb-3">
                            <span class="input-group-text">상품번호</span>
                            <input type="text" name="pno" class="form-control"
                                   value=<c:out value="${dto.pno}"></c:out> readonly>
                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text">상품이름</span>
                            <input type="text" name="pname" class="form-control"
                                   value='<c:out value="${dto.pname}"></c:out>' readonly>
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">상품가격</span>
                            <input type="text" name="price" class="form-control"
                                   value=<c:out value="${dto.price}"></c:out> readonly>

                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">inventory</span>
                            <input type="text" inventory="writer" class="form-control"
                                   value=<c:out value="${dto.inventory}"></c:out> readonly>

                        </div>



                        <div class="my-4">
                            <div class="float-end">
                                <button type="button" class="btn btn-primary">Modify</button>
                                <button type="button" class="btn btn-secondary">List</button>
                            </div>
                        </div>

                        <script>

                            // "document.querySelector(".btn-primary")"는 HTML 문서 내에서 class가 "btn-primary"인 첫 번째 요소를 선택합니다.
                            // "addEventListener" 함수는 선택한 요소에 이벤트 리스너를 추가합니다. 여기서는 "click" 이벤트에 대한 리스너를 추가합니다.
                            document.querySelector(".btn-primary").addEventListener("click", function(e){


                                self.location = `/product/modify?pno=${dto.pno}&${pageRequestDTO.link}`

                            },false)

                            document.querySelector(".btn-secondary").addEventListener("click", function(e){

                                self.location = "/product/list?${pageRequestDTO.link}"

                            },false)

                        </script>


                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="row content">
    </div>
    <div class="row footer">
        <!--<h1>Footer</h1>-->

        <div class="row   fixed-bottom" style="z-index: -100">
            <footer class="py-1 my-1 ">
                <p class="text-center text-muted">Footer</p>
            </footer>
        </div>

    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>