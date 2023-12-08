import './App.css';

// import 여기서사용할이름 'from js파일경로';
import ClassComponent from './components/R01_ClassComponent';
import FunctionComponent from './components/R02_FunctionComponent';

import Props1 from './components/R03_Props1';
import Props2 from './components/R04_Props2';
import Props3 from './components/R05_Props3';

import State1 from './components/R06_State1';
import State2 from './components/R07_State2';
import State3 from './components/R08_State3';


/* =================================================== */
/* 
  - React의 컴포넌트는 딱 하나의 요소만을 반환할 수 있다
  - 여러 요소를 반환하고 싶을 때 부모 요소로 묶어준다!
*/
/* =================================================== */
function App() {
  return (
    /* <></> (fragment, 조각) : 반환되는 요소를 감싸는 태그, 해석 X */
    <>
      <h1>테스트</h1>

      {/* jsx 주석 */}
      {/* <ClassComponent/> */}
      {/* <ClassComponent/> */}
      
      <hr/>

      {/* <FunctionComponent/> */}
      {/* <FunctionComponent/> */}

     {/*  <hr/>

      <Props1 />
      <Props1 name='홍길동' num='1'/>
      <Props1 name='김철수' num='2'/>

      <hr/>

      <Props2 name='강감찬' age='72' address='낙성대' gender='남자'/>
      <Props2 name='천추태후' age='66' address='개경' gender='여자'/>

      <hr/>
      <Props3 name='김민규'/>
      <Props3 name='윤성국'/> */}

      <State1 />

      <hr/>
      <State2 init={0}/>
      <State2 init={100}/>

      <hr/>
      <State3 />
    </>
  );
}

export default App;
