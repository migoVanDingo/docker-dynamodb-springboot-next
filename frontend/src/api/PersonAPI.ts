const PersonAPI = () => {


    const createPerson = async (name: string) => {

        
        const response = await fetch("http://localhost:8080/person/create", {
            method: 'POST',
            body: JSON.stringify({
              name: name,
            }),
            headers: {
              'Content-Type': 'application/json'
            }
            
          })
         
      
          const resData = await response.json();
          console.log('resData: ' + JSON.stringify(resData))
          if (!response.ok) {
            throw new Error(resData.message || 'Adding the goal failed.');
          }
      
          return resData;
    }

    const getPersons = async () => {
    
        const response = await fetch('http://localhost:8080/person')
        const resData = await response.json()
        
    
        if(!response.ok){
          throw new Error(resData.message || 'ya momma')
        }
    
        console.log("data: " + JSON.stringify(resData))
     
        return resData
      }

    return {
        createPerson,
        getPersons
    }
}

export default PersonAPI;