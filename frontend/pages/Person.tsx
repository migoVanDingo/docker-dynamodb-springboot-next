import React, { useState } from 'react'
import PersonAPI from '../src/api/PersonAPI';

function Person(){
    const [name, setName] = useState<string>('')

    const api = PersonAPI()
  
  
    const handleCreate = () => {
      const person = api.createPerson(name);
    }
  
    const handleGetAll = () => {
      const data = api.getPersons()
      console.log(JSON.stringify(data))
    }
  
    const handleChangeTextInput = (event: React.ChangeEvent<HTMLInputElement>) => {
      setName(event.target.value)
      console.log(event.target.value)
    }
  
    return (
      <div>
        <input type='text' id="create-name" onChange={handleChangeTextInput}/>
        <button onClick={handleCreate}>Create</button>
       <button onClick={handleGetAll}>GetAll</button>
      </div>
    );
}

export default Person