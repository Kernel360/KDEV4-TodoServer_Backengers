import { useState } from 'react'
import TextField from './TextField'

interface TodoCreatorProps {
  todos: string[]
}

export default function TodoCreator({ todos }: TodoCreatorProps) {
  const [todo, setTodo] = useState<string>('')

  const handleAdd = (todo: string) => {}

  return (
    <>
      <TextField />
      <button onClick={() => handleAdd(todo)}>추가</button>
    </>
  )
}
