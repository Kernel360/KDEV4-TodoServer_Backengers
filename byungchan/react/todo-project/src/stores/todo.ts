import { Todo } from '@/types/types'
import { create } from 'zustand'
import { combine } from 'zustand/middleware'

export const useTodoStore = create(
  // combine(상태, 액션함수)
  combine(
    {
      todos: [] as Todo[]
    },
    (set, get) => ({
      getTodos: async () => {
        const todos: Todo[] = await requestTodos({})
        set({
          todos
        })
      },
      createTodo: async (title: string) => {
        const data: Todo = await requestTodos({
          method: 'POST',
          endpoint: '',
          data: { title }
        })
        const { todos } = get() // 객체 구조 분해 할당
        set({
          todos: [data, ...todos]
        })
      },
      updateTodo: async () => {},
      deleteTodo: async () => {}
    })
  )
)

async function requestTodos(payload: {
  endpoint?: string
  method?: 'GET' | 'POST' | 'PUT' | 'DELETE'
  data?: unknown
}) {
  const { endpoint = '', method = 'GET', data } = payload

  const res = await fetch(
    `https://asia-northeast3-heropy-api.cloudfunctions.net/api/todos${endpoint}`,
    {
      method,
      headers: {
        'content-type': 'application/json',
        apikey: 'KDT8_bcAWVpD8',
        username: 'KDT8_ParkYoungWoong'
      },
      body: data ? JSON.stringify(data) : undefined
    }
  )
  return res.json()
}
