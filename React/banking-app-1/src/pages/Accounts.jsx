import { useEffect,useState } from "react";

function Accounts() {
    const [user, setUser] = useState(null);

    useEffect(() => {
        async function fetchUser() {
            try {
                const response = await fetch("https://jsonplaceholder.typicode.com/users");
                const data = await response.json();
                setUser(data);
            } catch (error) {
                console.error("Error fetching user data:", error);
            }
        }
        fetchUser();
    }, []);

    return (
        <div>
            Users
            {user ? (
                <div>
                    <ul>
                        {user.map((user) => (
                            <li key={user.id}>
                                {user.name} - {user.email}
                            </li>
                        ))}
                    </ul>
                </div>
            ) : (
                <p>Loading...</p>
            )}  
        </div>
    )
}

export default Accounts;