package net.sbaai.restoapp.dao;

import net.sbaai.restoapp.model.*;

import java.util.List;

public interface IOperation {
    //Category
    public Category addCategory(Category c);

    public List<Category> listCategoriy();

    public Category getCategory(Long idCat);

    public void deleteCategory(Long idCat);

    public void updateCategory(Category c);

//Food

    public Food addFood(Food f);

    public List<Food> listFoods();

    public List<Food> foodsByName(String name);

    public List<Food> foodsByCategory(Long idCat);

    public List<Food> foodsSelectionnes();

    public Food getFoodById(Long idFood);

    public void deleteFood(Long idFood);

    public void updateFood(Food f);

    //Commande
    public Command saveCommand(Basket b, Customer c, Tables t);

    public void updateCommand(Command c, Basket b);

    public Command getCommand(String numCommand);

    public void deleteCommande(String numCommand);

    public List<Command> getAllCommand();

    public List<Command> getCommandByDate(String date);


    //Customer
    public Customer addCustomer(Customer c);

    public List<Customer> getAllCustomer();

    public Customer getCustomerById(Long id);

    public List<Customer> getCustomersByMc(String mc);

    public void updateCustomer(Customer c);

    public void deleteCustomer(Long id);

    //Tables
    public Tables addTables(Tables t);

    public List<Tables> getAllTables();

    public List<Tables> getTablesBySector(Long idSector);

    public Tables getTablesById(Long id);

    public List<Tables> getTablesByWaiter(Long idWaiter);

    public void updateTables(Tables t);

    public void deleteTables(Long id);

    public List<Tables> getTablesByMC(String mc);

    //Waiter
    public Waiter addWaiter(Waiter w);

    public List<Waiter> getAllWaiter();

    public List<Waiter> getWaiterByMC(String mc);

    public Waiter getWaiterById(Long id);

    public void updateWaiter(Waiter w);

    public void deleteWaiter(Long id);

    //Sector
    public Sector addSector(Sector s);

    public List<Sector> getAllSector();

    public List<Sector> getSetorsByMc(String mc);

    public Sector getSectorById(Long id);

    public void updateSector(Sector s);

    public void deleteSector(Long id);

    //Cachier
    public Cashier addCashier(Cashier c);

    public List<Cashier> getAllCashiers();

    public void deleteCashier(Long id);

    public Cashier getCashier(Long id);

    public List<Cashier> getCashierbyDate(String date);

    //user
    public Users addUser(Users u);

    public List<Users> getAllUsers();

    public List<Users> UserConnect(String username, String password);

    public void deleteUser(Long id);

    public void updateUser(Users u);

    public Users getUserById(Long id);

    //message
    public Message addMessage(Message msg);

    public List<Message> getAllMessages();


//ligne de commande

    public List<Cashier> getCmdlignes();

    public List<Cashier> getCmdlignesByDate(String date);


}
