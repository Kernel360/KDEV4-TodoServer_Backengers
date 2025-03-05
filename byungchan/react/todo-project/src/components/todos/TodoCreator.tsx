import { ChangeEvent, useRef, useState } from 'react'
import { useTodoStore } from '@/stores/todo'

export default function TodoCreator() {
  const [title, setTitle] = useState<string>('')
  const createTodo = useTodoStore(state => state.createTodo)
  const inputRef = useRef<HTMLInputElement>(null)

  const handleChange = (event: ChangeEvent<HTMLInputElement>) =>
    setTitle(event.currentTarget.value)

  const handleAdd = (title: string) => {
    createTodo(title)
    setTitle('')
  }

  return (
    <>
      <h1>{title}</h1>
      <input
        className="rounded-md"
        type="text"
        value={title}
        onChange={handleChange}
        onKeyDown={e => {
          // 한글이 입력 중이다...
          if (e.nativeEvent.isComposing) return
          if (e.key === 'Enter') {
            handleAdd(title)
          }
        }}
        ref={inputRef}
      />
      <button onClick={() => handleAdd(title)}>추가</button>
    </>
  )
}
