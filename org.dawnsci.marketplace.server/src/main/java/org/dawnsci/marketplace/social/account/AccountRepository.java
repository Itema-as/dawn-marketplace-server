/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dawnsci.marketplace.social.account;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface AccountRepository extends PagingAndSortingRepository<Account, String> {
	
	void createAccount(Account account) throws UsernameAlreadyInUseException;
	
	void createAccountSolutionMapping(Account account, Long id);
	
	Account findAccountBySolutionId(Long id);
	
	boolean isAdministrator(String id);
	
	boolean isUser(String id);

	void setAdministrator(String username, boolean administrator);

	void setUser(String username, boolean user);

	List<Long> findSolutionIdsByUsername(String id);
}
