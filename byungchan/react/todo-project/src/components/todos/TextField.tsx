import { ChangeEvent, useState } from 'react'

interface TextFieldProps {
  onCreate: (value: string) => void
}

export default function TextField() {
  const [value, setValue] = useState<string>('')

  const handleChange = (event: ChangeEvent<HTMLInputElement>) =>
    setValue(event.currentTarget.value)

  return (
    <input
      type="text"
      value={value}
      onChange={handleChange}
    />
  )
}
