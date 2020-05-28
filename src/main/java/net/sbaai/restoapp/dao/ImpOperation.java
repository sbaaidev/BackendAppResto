package net.sbaai.restoapp.dao;

import net.sbaai.restoapp.model.*;
import net.sbaai.restoapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Transactional
@Service
public class ImpOperation implements IOperation{
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	FoodRepository foodRepository;
	@Autowired
	CommandRepository commandRepository;
	@Autowired
	CommandlineRepository commandlineRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	MessageRepository messageRepository;
	@Autowired
	SectorRepository sectorRepository;
	@Autowired
	TablesRepository tablesRepository;
	@Autowired
	SubCategoryRepository subCategoryRepository;
	@Autowired
	WaiterRepository waiterRepository;
	@Autowired
	CashierRepository cashierRepository;
	@Autowired
	UsersRepository usersRepository;

	@Override
	public Category addCategory(Category c) {
		return categoryRepository.save(c);
		//return c.getIdCategory();
	}

	@Override
	public List<Category> listCategoriy() {
		//Query req=em.createQuery("select c from Category c");
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategory(Long idCat) {
		
		return categoryRepository.findById(idCat).get();
	}

	@Override
	public void deleteCategory(Long idCat) {
		categoryRepository.deleteById(idCat);
	}

	@Override
	public void updateCategory(Category c) {
		categoryRepository.save(c);
		
	}

	@Override
	public Food addFood(Food f) {
		return foodRepository.save(f);
		//return f.getIdFood();
	}

	@Override
	public List<Food> listFoods() {
		return foodRepository.findAll();
	}

	@Override
	public List<Food> foodsByName(String name) {
      return foodRepository.findFoodByName(name);
	}

	@Override
	public List<Food> foodsByCategory(Long idCat) {
		return foodRepository.findFoodByCategory_IdCategory(idCat);
	}

	@Override
	public List<Food> foodsSelectionnes() {
		return foodRepository.findFoodBySelected(true);
	}

	@Override
	public Food getFoodById(Long idFood)
	{
		return foodRepository.findById(idFood).get();
	}

	@Override
	public void deleteFood(Long idFood) {
		foodRepository.deleteById(idFood);
	}

	@Override
	public void updateFood(Food f) {
		foodRepository.save(f);
	
	}

	@Override
	public Command saveCommand(Basket b, Customer c,Tables t) {
		//em.persist(c);
		int numcmd=1;
		String getnum;
		List<Command> cmds=commandRepository.findAllOrderByIdCommandAsc();
		if(cmds.size()>0){
			System.out.println(cmds.get(cmds.size()-1).getNumCommand());
			getnum=cmds.get(cmds.size()-1).getNumCommand();

			if(LocalDate.now().getMonthValue()!=LocalDateTime.ofInstant(cmds.get(cmds.size()-1).getDtaeCommand().toInstant(),ZoneId.systemDefault()).getMonthValue()){
				if(getCommand("1-"+LocalDate.now().getMonthValue()+LocalDate.now().getYear())==null){
					numcmd=1;
				}else{
					numcmd=Integer.parseInt(getnum.split("-")[0])+1;
				}		
			}else{
				numcmd=Integer.parseInt(getnum.split("-")[0])+1;
			}
				
		}else{
			System.out.println("non");
		}
		Command cmd=new Command();
		cmd.setTable(t);
		cmd.setDatenotime(new Date());
		cmd.setCustomer(c);
		cmd.setDtaeCommand(new Date());
		cmd.setNumCommand(numcmd+"-"+LocalDate.now().getMonthValue()+LocalDate.now().getYear());
		//cmd.setNumCommand(numcmd+"-"+new Date().getMonth());
		for(Command_line cl:b.getItems()){
			cl.setCommand(cmd);
			cl.setDate(cmd.getDatenotime());
			//commandlineRepository.save(cl);
		}
		cmd.setCommand_line(b.getItems());
		commandRepository.save(cmd);

		
		return cmd;
	}

	@Override
	public void updateCommand(Command c,Basket b) {
		Command cc=commandRepository.findById(c.getNumCommand()).get();
		for(Command_line cl:cc.getCommand_line()){
			commandlineRepository.delete(cl);
		}
		for(Command_line cl:b.getItems()){
			cl.setCommand(c);
			cl.setDate(c.getDatenotime());
		}
		c.setCommand_line(b.getItems());
		commandRepository.save(c);
	}
	@Override
	public Command getCommand(String numCommand) {

		Command c= commandRepository.findById(numCommand).get();
		try{
		//Query req=em.createQuery("select cl from Command_line cl where numCommand =:x");
		//req.setParameter("x", numCommand);
		//c.setCommand_line(req.getResultList());
			c.setCommand_line(commandlineRepository.getCommand_lineByCommand_NumCommand(numCommand));
		}catch(Exception e){
		System.out.println(e.getMessage());	
		}
		return c ;
	}
	@Override
	public void deleteCommande(String numCommand) {
		commandRepository.deleteById(numCommand);
	}

	@Override
	public Customer addCustomer(Customer c) {
		return customerRepository.save(c);
	}
	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public List<Customer> getCustomersByMc(String mc) {
		return customerRepository.findCustomerByNameContaining(mc);
	}

	@Override
	public void updateCustomer(Customer c) {
		customerRepository.save(c);
	}
	@Override
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}
	@Override
	public Tables addTables(Tables t) {
		return tablesRepository.save(t);
	}
	@Override
	public List<Tables> getAllTables() {
		//Query req=em.createQuery("select t from Tables t");
		return tablesRepository.findAll();
	}
	@Override
	public List<Tables> getTablesBySector(Long idSector) {
		//Query req=em.createQuery("select t from Tables t where t.sector.idSector=:x");
		//req.setParameter("x", idSector);
		return tablesRepository.findTablesBySector_IdSector(idSector);
	}
	@Override
	public Tables getTablesById(Long id) {
		return tablesRepository.findById(id).get();
	}
	@Override
	public List<Tables> getTablesByWaiter(Long idWaiter) {
		//Query req=em.createQuery("select t from Tables t where t.waiter.idWaiter=:x");
		//req.setParameter("x", idWaiter);
		return tablesRepository.findTablesByWaiter_IdWaiter(idWaiter);
	}
	@Override
	public void updateTables(Tables t) {
		tablesRepository.save(t);
	}
	@Override
	public void deleteTables(Long id) {
		tablesRepository.deleteById(id);
	}
	@Override
	public SubCategory addSubCategory(SubCategory u) {
		return subCategoryRepository.save(u);

	}
	@Override
	public List<SubCategory> getAllSubCategory() {
		return subCategoryRepository.findAll();
	}
	@Override
	public SubCategory getSubCategoryById(Long id) {
		return subCategoryRepository.findById(id).get();
	}
	@Override
	public void updateSubCategory(SubCategory u) {
		subCategoryRepository.save(u);
	}
	@Override
	public void deleteSubCategory(Long id) {
		subCategoryRepository.deleteById(id);
	}
	@Override
	public Waiter addWaiter(Waiter w) {
		return waiterRepository.save(w);

	}
	@Override
	public List<Waiter> getAllWaiter() {
		return waiterRepository.findAll();
	}
	@Override
	public List<Waiter> getWaiterByMC(String mc) {
		return waiterRepository.findWaiterByMC("%"+mc+"%");
	}
	@Override
	public Waiter getWaiterById(Long id) {
	
		return waiterRepository.findById(id).get();
	}
	@Override
	public void updateWaiter(Waiter w) {
	waiterRepository.save(w);
	}
	@Override
	public void deleteWaiter(Long id) {
		waiterRepository.deleteById(id);
		
	}
	@Override
	public Sector addSector(Sector s) {
		return sectorRepository.save(s);
	}
	@Override
	public List<Sector> getAllSector() {
		return sectorRepository.findAll();
	}
	@Override
	public List<Sector> getSetorsByMc(String mc) {

		return sectorRepository.findSectorByNameContaining(mc);

	}
	@Override
	public Sector getSectorById(Long id) {
		return sectorRepository.findById(id).get();
	}
	@Override
	public void updateSector(Sector s) {
		sectorRepository.save(s);
	}
	@Override
	public void deleteSector(Long id) {
		sectorRepository.deleteById(id);
	}
	@Override
	public List<Tables> getTablesByMC(String mc) {
		return tablesRepository.findTablesByMC("%"+mc+"%");
	}
	@Override
	public List<Command> getAllCommand() {
		List <Command> cmds=new ArrayList<Command>();
		List <Command> cmds2=new ArrayList<Command>();


		cmds=commandRepository.findAll();
		for(Command c:cmds){
			c.setCommand_line(commandlineRepository.getCommand_lineByCommand_NumCommand(c.getNumCommand()));
			cmds2.add(c);
		}
		return cmds2;
	}
	@Override
	public List<Command> getCommandByDate(String date) {
		//Query req=em.createQuery("select c from Command c where dtaeCommand like :x");
		//Query req=em.createQuery("select * from command where dtaeCommand like :x");
		return commandRepository.findCommandByDtaeCommandContaining(date);
	}
	@Override
	public Cashier addCashier(Cashier c) {
		 return cashierRepository.save(c);
	}
	@Override
	public List<Cashier> getAllCashiers() {
		return cashierRepository.findAll();
	}
	@Override
	public void deleteCashier(Long id) {
		cashierRepository.deleteById(id);
	}

	@Override
	public Cashier getCashier(Long id) {
		return cashierRepository.findById(id).get();
	}

	@Override
	public List<Cashier> getCashierbyDate(String date) {

		return cashierRepository.findCashierByDateContaining(date);
	}

	@Override
	public Users addUser(Users u) {
		return usersRepository.save(u);
	}

	@Override
	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}

	@Override
	public List<Users> UserConnect(String username, String password) {
		//Query req=em.createQuery("select u from Users u where u.username=:x and u.password=:y ");
		//req.setParameter("x", username);
		//req.setParameter("y", password);
		return usersRepository.findUsersByUsernameAndPassword(username,password);
	}
	@Override
	public void deleteUser(Long id) {
		usersRepository.deleteById(id);
		
	}

	@Override
	public void updateUser(Users u) {
		usersRepository.save(u);
		
	}

	@Override
	public Users getUserById(Long id) {
		
		return usersRepository.findById(id).get();
	}

	@Override
	public Message addMessage(Message msg) {
		return messageRepository.save(msg);
	}

	@Override
	public List<Message> getAllMessages() {
		//Query req=em.createQuery("select m from Message m order by m.idmsg");
		return messageRepository.findMessageAndOrderByIdmsg();
	}

	@Override
	public List<Cashier> getCmdlignes() {
		List<Cashier> cashs=new ArrayList<>();
				//Connection conn=ConnectionSingleton.getConn();
				//PreparedStatement pr;
				try {
					//pr = conn.prepareStatement("select sum(prix) as prix,date from command_line group by date");
					List<Object[]> res = commandlineRepository.getSumPrixAndDate();
					//ResultSet rs=pr.executeQuery();

					for (Object[] o : res) {
						Cashier cs = new Cashier();
						cs.setPrice(Double.parseDouble(o[0].toString()));
						cs.setDate(o[1].toString());
						cashs.add(cs);

					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				return cashs;
	
	}	
			
			

	@Override
	public List<Cashier> getCmdlignesByDate(String date) {
		List<Cashier> cashs=new ArrayList<>();
		//Connection conn=ConnectionSingleton.getConn();
		PreparedStatement pr;
		try {
			//pr = conn.prepareStatement("select sum(prix) as prix,date from command_line where date like ? group by date");
			//pr.setString(1, "%"+date+"%");
			List<Object> res=commandlineRepository.getSumPrixAndDateGroupByDate("%"+date+"%");
			//ResultSet rs=pr.executeQuery();
			for(Object o:res){
				Cashier cs=new Cashier();
				cs.setPrice(Double.parseDouble(o.toString()));
				cs.setDate(o.toString());
				cashs.add(cs);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cashs;
		
	}
	
	
}
