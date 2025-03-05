import { Todo } from '@/types/types'
import { useState } from 'react'

interface TodoItemProps {
  todo: Todo
}

export default function TodoItem({ todo }: TodoItemProps) {
  const [isEdit, setIsEdit] = useState(false)
  const [inputTitle, setInputTitle] = useState(todo.title)

  const handleSave = () => {}

  const handleDelete = () => {}

  const handleCancel = () => {
    setIsEdit(false)
    setInputTitle(todo.title)
  }

  const handleEditMode = () => {
    setIsEdit(true)
  }

  return (
    <li key={todo.id}>
      {isEdit ? (
        <>
          <input
            type="text"
            value={inputTitle}
            onChange={e => setInputTitle(e.currentTarget.value)}
          />
          <button onClick={handleCancel}>취소</button>
          <button onClick={handleSave}>저장</button>
        </>
      ) : (
        <>
          <p>{todo.title}</p>
          <button onClick={handleEditMode}>수정</button>
          <button>삭제</button>
        </>
      )}
    </li>
  )
}
