// 입력 요소
const num1 = document.getElementById("num1"); // 아이디 속성 값
const num2 = document.querySelector("#num2"); // css선택자

// 결과 요소
const result = document.getElementById("result");

// 더하기 버튼 
function plus(){
  // 입력요소.value : 입력 요소에 작성된 값 반환(string)
  console.log(num1.value);
  console.log(num2.value);
  
  // Number("123") == 123  (숫자로 변환)
  console.log(Number(num1.value) + Number(num2.value));

  // 요소.innerText : <시작>내용</종료>  , 내용에 글자 대입
  result.innerText = Number(num1.value) + Number(num2.value);

}

// 빼기 버튼 
function minus(){
  result.innerText = Number(num1.value) - Number(num2.value);
}

function multi(){
  result.innerText = Number(num1.value) * Number(num2.value);
}

function div(){
  result.innerText = Number(num1.value) / Number(num2.value);
}

function mod(){
  result.innerText = Number(num1.value) % Number(num2.value);
}