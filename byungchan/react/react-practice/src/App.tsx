import { useState } from 'react'
import List from '@/components/List'
import TextField from '@/components/TextField'
// 경로 별칭(path alias)

export default function App() {
  // const countState = useState<number>(0);
  // const count = countState[0];
  // const setCount = countState[1];
  // 여기서 count 는 Read Only 데이터
  const [count, setCount] = useState<number>(0)

  function increment() {
    const _count = count + 1
    setCount(_count)
    console.log(_count)
  }

  return (
    <>
      <h1
        className={`bg-red-500 text-4xl font-bold ${count > 7 ? 'active' : ''}`}
        onClick={increment}>
        App.tsx({count})
      </h1>
      {/* count > 0 ? () : null */}
      {count > 0 && (
        <button
          className="m-1"
          onClick={() => setCount(0)}>
          초기화
        </button>
      )}
      <List />
      <TextField />
    </>
  )
}
