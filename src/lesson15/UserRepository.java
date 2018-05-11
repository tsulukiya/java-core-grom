package lesson15;


public class UserRepository {
    private User[] users = new User[10];

    public int count() {
        int count = 0;
        for (User user : users) {
            if (user != null)
                count++;

        }
        return count;
    }

    public String[] getUserNames() {
        String[] names = new String[count()];
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                names[i] = users[i].getName();
        }
        return names;
    }

    public long[] getUserIds() {
        long[] id = new long[count()];
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                id[i] = users[i].getId();
        }
        return id;
    }

    public String getUserNameById(long id) {
        String nameUser = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                if (users[i].getId() == id) {
                    nameUser = users[i].getName();
                }
        }
        return nameUser;
    }

    public User getUserByName(String name) {
        User user1 = null;
        for (User user : users) {
            if (user != null) {
                if (user.getName() == name) {
                    user1 = user;
                    break;
                }
            }
        }
        return user1;
    }

    public User getUserById(long id) {
        User user1 = null;
        for (User user : users) {
            if (user != null) {
                if (user.getId() == id) {
                    user1 = user;
                    break;
                }
            }
        }
        return user1;
    }


    public User findById(long id) {
        User user1 = null;
        for (User user : users) {
            if (user != null) {
                if (user.getId() == id) {
                    user1 = user;
                    break;
                }
            }
        }
        return user1;
    }


    public User getUserBySessionId(String sessionId) {
        User user1 = null;
        for (User user : users) {
            if (user != null) {
                if (user.getSessionId() == sessionId) {
                    user1 = user;
                    break;
                }
            }
        }
        return user1;
    }


    public User save(User user) {
        User user1 = null;

        for (User user2 : users) {
            if (user2.equals(user))
                user1 = user2;

        }

        if (user1 == null) {
            for (User user2 : users) {
                if (user2 == null) {
                    user1 = user2;
                }
            }

        }
        return user1;
    }


    public User update(User user) {
        User user1 = findById(user.getId());
        if (user1 != null) {
            for (int i = 0; i < users.length; i++) {
                if (user != null)
                    if (users[i].getId() == user.getId()) {
                        users[i] = user;
                        user1 = users[i];
                        break;
                    }
            }

        }

        return user1;

    }


    public void delete(long id) {

        if (findById(id) != null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null) {
                    if (users[i].getId() == findById(id).getId())
                        users[i] = null;
                }
                break;
            }
        }
    }


    public User[] getUsers() {
        return users;
    }
}

