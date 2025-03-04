import { useState } from 'react'

interface Fruit {
  name: string
  key: string
}

export default function List() {
  const [fruits, setFruits] = useState<Fruit[]>([
    { name: '사과', key: 'Apple' },
    { name: '바나나', key: 'Banana' },
    { name: '체리', key: 'Cherry' }
  ])
  return (
    <ul>
      {fruits.map(({ key, name }) => (
        <li key={key}>{name}</li>
      ))}
    </ul>
  )
}
