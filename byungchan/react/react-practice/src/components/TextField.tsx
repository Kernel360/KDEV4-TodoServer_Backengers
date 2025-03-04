import { useEffect, useRef } from 'react'

export default function TextField() {
  const inputRef = useRef<HTMLInputElement | null>(null)

  // useEffect(callback, [dependency])
  // dependency 가 [] 이면 callback 은 1번만 호출됨.
  // dependency 가 [] 이 아니면 dependency 에 있는 요소의 값이 변경될 때마다 호출됨.
  useEffect(() => {
    // TypeScript 의 Optional Chaining 문법
    inputRef.current?.focus()
  }, [])

  // 컴포넌트 생명주기 (lifecycle)

  return (
    <input
      type="text"
      ref={inputRef}
    />
  )
}
